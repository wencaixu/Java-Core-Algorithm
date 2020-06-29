package com.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author wencai.xu
 */
public class OkHttpRequest {

    public static String getResponseBody(String url){
        String responseBody = "";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try(Response response = client.newCall(request).execute()){
            responseBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;
    }


    public static void main(String[] args) {
        System.out.println(getResponseBody("http://39.106.113.6:8888/seeAllMovies"));
    }


}
