package com.example.eric.myapplication.testAPI;

import android.util.Log;

import com.tylerjroach.eventsource.EventSourceHandler;
import com.tylerjroach.eventsource.MessageEvent;

/**
 * Created by eric on 7/4/17.
 */

public class SSEHandler implements EventSourceHandler {

    public SSEHandler() {
        Log.d("hi","SSEHandler");
    }

    @Override
    public void onConnect() {
        Log.d("hi","onConnect");
        Log.v("SSE Connected", "True");
    }

    @Override
    public void onMessage(String event, MessageEvent message) {
        Log.v("SSE Message", event);
        Log.v("SSE Message2: ", message.data);
    }

    @Override
    public void onComment(String comment) {
        //comments only received if exposeComments turned on
        Log.v("SSE Comment", comment);
    }

    @Override
    public void onError(Throwable t) {
        //ignore ssl NPE on eventSource.close()
    }

    @Override
    public void onClosed(boolean willReconnect) {
        Log.v("SSE Closed", "reconnect? " + willReconnect);
    }
}
