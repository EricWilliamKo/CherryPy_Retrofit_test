package com.example.eric.myapplication.test.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eric on 6/29/17.
 */

public class Response implements Parcelable {
//    public static final Parcelable.Creator<Response> CREATOR = new AnswerCreator();

    @SerializedName("fuck")
    private final String response;

    private Response(Parcel in){
        response = in.readString();
    }

    public String getText() {
        return response;
    }


//    public static final Creator<Response> CREATOR = new Creator<Response>() {
//        @Override
//        public Response createFromParcel(Parcel in) {
//            return new Response(in);
//        }
//    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(response);
    }

    private static class AnswerCreator implements Parcelable.Creator<Response> {
        @Override
        public Response createFromParcel(Parcel source) {
            return new Response(source);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
        }
    }
}
