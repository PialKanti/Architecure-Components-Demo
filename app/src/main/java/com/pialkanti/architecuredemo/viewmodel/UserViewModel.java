package com.pialkanti.architecuredemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.pialkanti.architecuredemo.http.ApiResponse;
import com.pialkanti.architecuredemo.pojo.User;
import com.pialkanti.architecuredemo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pial Kanti Samadder<pialkanti2012@gmail.com>
 * Date: 11/18/2017
 * Time: 10:43 AM
 */

public class UserViewModel extends ViewModel {
    private LiveData<ApiResponse> response;
    private LiveData<User> user;
    private UserRepository repository;

    public UserViewModel() {
        repository = new UserRepository();
    }

    public void init() {
        response = repository.getUsers();
        //user = repository.getUser();
    }

    public LiveData<ApiResponse> getUsers() {
        return response;
    }

    public LiveData<User> getUser() {
        return user;
    }
}

