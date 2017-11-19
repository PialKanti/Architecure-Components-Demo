package com.pialkanti.architecuredemo.http;

import com.pialkanti.architecuredemo.pojo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author: Pial Kanti Samadder<pialkanti2012@gmail.com>
 * Date: 11/18/2017
 * Time: 10:46 AM
 */

public interface ApiInterface {
    @GET("users")
    Call<List<User>> getUsers();
    @GET("user")
    Call<User> getUser();
}
