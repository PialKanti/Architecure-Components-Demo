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
    private UserRepository repository;

    public UserViewModel() {
        repository = new UserRepository();
    }

    public void init() {
        if (users != null) {
            return;
        }
        users = repository.getUsers();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }
}

