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
    @GET("5a0fe45e2f00005b15ec5404")
    Call<List<User>> getUser();
}
