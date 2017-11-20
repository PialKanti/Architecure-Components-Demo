package com.pialkanti.architecuredemo.http;

import com.pialkanti.architecuredemo.pojo.User;

import java.util.ArrayList;

/**
 * @author: Pial Kanti Samadder<pialkanti2012@gmail.com>
 * Date: 11/20/2017
 * Time: 3:15 PM
 */

public class ApiResponse {
    public ArrayList<User> users;
    public Throwable error;

    public ApiResponse(ArrayList<User> users) {
        this.users = users;
        this.error = null;
    }

    public ApiResponse(Throwable error) {
        this.users = null;
        this.error = error;
    }
}
