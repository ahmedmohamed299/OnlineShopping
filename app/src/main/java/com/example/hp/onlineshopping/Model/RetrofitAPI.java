package com.example.hp.onlineshopping.Model;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {
    APIs apIs;


    private static Retrofit retrofitinstance;

    public static Retrofit getInstance(){
        if (retrofitinstance==null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
            okHttpClient.connectTimeout(60, TimeUnit.SECONDS);
            okHttpClient.readTimeout(60,TimeUnit.SECONDS);
            okHttpClient.addInterceptor(logging);
            //Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            retrofitinstance = new Retrofit.Builder()
                    .baseUrl("http://pazstore.com/api/")
                    .client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitinstance;
    }

    public static APIs getApiService(){
        return getInstance().create(APIs.class);
    }




}