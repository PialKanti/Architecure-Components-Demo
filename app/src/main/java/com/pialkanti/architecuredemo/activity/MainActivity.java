package com.pialkanti.architecuredemo.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pialkanti.architecuredemo.R;
import com.pialkanti.architecuredemo.adapter.UserAdapter;
import com.pialkanti.architecuredemo.pojo.User;
import com.pialkanti.architecuredemo.viewmodel.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView userList;
    private RecyclerView.LayoutManager layoutManager;
    private UserAdapter mAdapter;
    private UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        viewModel.init();
        viewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                mAdapter.setUsers(users);
            }
        });
    }

    public void initialize() {
        userList = (RecyclerView) findViewById(R.id.rUserList);
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new UserAdapter();
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        // Setting LayoutManager
        userList.setLayoutManager(layoutManager);
        // Setting Adapter
        userList.setAdapter(mAdapter);

    }
}
