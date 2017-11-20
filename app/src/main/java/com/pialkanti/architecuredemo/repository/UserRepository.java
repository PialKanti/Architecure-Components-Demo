package com.pialkanti.architecuredemo.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.pialkanti.architecuredemo.http.ApiClient;
import com.pialkanti.architecuredemo.http.ApiInterface;
import com.pialkanti.architecuredemo.http.ApiResponse;
import com.pialkanti.architecuredemo.pojo.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author: Pial Kanti Samadder<pialkanti2012@gmail.com>
 * Date: 11/18/2017
 * Time: 10:44 AM
 */

public class UserRepository {
    private ApiInterface api;
    private final String TAG = "UserRepo";


    public LiveData<ApiResponse> getUsers() {
        final MutableLiveData<ApiResponse> data = new MutableLiveData<>();
        api = ApiClient.getInstance().create(ApiInterface.class);
        Call<ArrayList<User>> call = api.getUsers();
        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                data.setValue(new ApiResponse(response.body()));
                Log.d(TAG, "Request Successful");//todo remove
                System.out.println("Request Successful");//todo remove
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                data.setValue(new ApiResponse(t));
                Log.d(TAG, "Request Failed");//todo remove
                System.out.println("Request Failed");//todo remove
            }
        });

        return data;
    }

    public LiveData<User> getUser() {
        final MutableLiveData<User> data = new MutableLiveData<>();
        api = ApiClient.getInstance().create(ApiInterface.class);
        api.getUser().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                data.setValue(response.body());
                System.out.println("Request Successful");//todo remove
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Request Failed");//todo remove
            }
        });
        return data;
    }
}
