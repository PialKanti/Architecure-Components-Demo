package com.pialkanti.architecuredemo.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.pialkanti.architecuredemo.http.ApiClient;
import com.pialkanti.architecuredemo.http.ApiInterface;
import com.pialkanti.architecuredemo.pojo.User;

import java.util.List;

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


    public LiveData<List<User>> getUsers() {
        final MutableLiveData<List<User>> data = new MutableLiveData<>();
        api = ApiClient.getInstance().create(ApiInterface.class);
        api.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                data.setValue(response.body());
                Log.d(TAG, "Request Successful");//todo remove
                System.out.println("Request Successful");//todo remove
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d(TAG, "Request Failed");//todo remove
                System.out.println("Request Failed");//todo remove
            }
        });
        return data;
    }

    public LiveData<User> getUser() {
        System.out.println("Check");
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
