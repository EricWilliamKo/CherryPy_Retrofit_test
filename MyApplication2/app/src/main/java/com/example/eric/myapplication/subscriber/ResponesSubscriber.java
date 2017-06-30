package com.example.eric.myapplication.subscriber;

import android.util.Log;

import com.example.eric.myapplication.test.model.Response;

import rx.Subscriber;

/**
 * Created by eric on 6/30/17.
 */

public class ResponesSubscriber extends Subscriber<Response> {
    private static final String TAG = "myTest";

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onNext(Response response) {
        final String text = response.getText();
        Log.d(TAG,"response:"+text);
    }
}
