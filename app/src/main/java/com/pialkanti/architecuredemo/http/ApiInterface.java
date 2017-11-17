package com.pialkanti.architecuredemo.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: Pial Kanti Samadder<pialkanti2012@gmail.com>
 * Date: 11/17/2017
 * Time: 5:19 PM
 */

public class ApiInterface {
    private static final String BASE_URL = "";
    private static Retrofit mRetrofit;

    public static Retrofit getInstance() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
