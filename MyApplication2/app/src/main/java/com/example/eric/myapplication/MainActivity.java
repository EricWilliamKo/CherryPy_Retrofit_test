package com.example.eric.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.eric.myapplication.subscriber.ResponesSubscriber;
import com.example.eric.myapplication.test.model.MyJSON;
import com.example.eric.myapplication.test.model.Response;
import com.example.eric.myapplication.testAPI.MyAPI;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume(){
        super.onResume();
        postToServer(new MyJSON("shit"));
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
