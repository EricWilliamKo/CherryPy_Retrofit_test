package com.example.eric.myapplication.testAPI;

import com.example.eric.myapplication.test.model.Response;
import com.example.eric.myapplication.test.model.MyJSON;

import retrofit2.http.Body;
import rx.Observable;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;


/**
 * Created by eric on 6/29/17.
 */

public class MyAPI {
    private static final String BASE_URL = "http://192.168.30.225:8080/";
    private static TestService sService;

    private static synchronized TestService getService() {
        if (sService == null) {
            final GsonConverterFactory converterFactory = GsonConverterFactory.create();
            final RxJavaCallAdapterFactory callAdapterFactory = RxJavaCallAdapterFactory.create();
            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(callAdapterFactory)
                    .build();
            sService = retrofit.create(TestService.class);
        }
        return sService;
    }

    public static Observable<Response> getResponse(MyJSON myJSON) {
        return getService().getResponse(myJSON);
    }

    private interface TestService{
        @POST("hey")
        Observable<Response> getResponse(@Body MyJSON myJSON);
    }
}
