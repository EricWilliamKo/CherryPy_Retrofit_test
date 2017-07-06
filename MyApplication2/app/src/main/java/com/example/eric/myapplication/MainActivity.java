package com.example.eric.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.eric.myapplication.subscriber.ResponesSubscriber;
import com.example.eric.myapplication.test.model.MyJSON;
import com.example.eric.myapplication.test.model.Response;
import com.example.eric.myapplication.testAPI.MyAPI;
import com.example.eric.myapplication.testAPI.SSEHandler;
import com.tylerjroach.eventsource.EventSource;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private SSEHandler sseHandler = new SSEHandler();
    private String eventUrl = "http://192.168.30.225:8080/stream";
    private EventSource eventSource;

    private void startEventSource() {
        Log.d("hi","startEventSource");
        eventSource = new EventSource.Builder(eventUrl)
                .eventHandler(sseHandler)
                .build();
        eventSource.connect();
    }

    private void stopEventSource() {
        if (eventSource != null)
            eventSource.close();
        sseHandler = null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume(){
        super.onResume();
        postToServer(new MyJSON("how are you?"));
        startEventSource();
    }

    @Override
    protected void onPause(){
        super.onPause();
        stopEventSource();
    }

    private void postToServer(MyJSON myJSON) {
        final Scheduler newThread = Schedulers.newThread();
        final Scheduler mainThread = AndroidSchedulers.mainThread();
        final Subscriber<Response> subscriber = new ResponesSubscriber();
        MyAPI.getResponse(myJSON)
                .subscribeOn(newThread)
                .observeOn(mainThread)
                .subscribe(subscriber);
    }

}
