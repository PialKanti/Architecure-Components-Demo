package com.pialkanti.architecuredemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.pialkanti.architecuredemo.pojo.User;
import com.pialkanti.architecuredemo.repository.UserRepository;

import java.util.List;

/**
 * @author: Pial Kanti Samadder<pialkanti2012@gmail.com>
 * Date: 11/18/2017
 * Time: 10:43 AM
 */

public class UserViewModel extends ViewModel {
    private LiveData<List<User>> users;
    private LiveData<User> user;
    private UserRepository repository;

    public void init() {
        if (user != null) {
            return;
        }
        repository = new UserRepository();
        //users = repository.getUsers();
        user = repository.getUser();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public LiveData<User> getUser() {
        return user;
    }
}

