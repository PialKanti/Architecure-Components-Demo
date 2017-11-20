package com.pialkanti.architecuredemo.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.pialkanti.architecuredemo.R;
import com.pialkanti.architecuredemo.adapter.UserAdapter;
import com.pialkanti.architecuredemo.http.ApiClient;
import com.pialkanti.architecuredemo.http.ApiInterface;
import com.pialkanti.architecuredemo.http.ApiResponse;
import com.pialkanti.architecuredemo.pojo.User;
import com.pialkanti.architecuredemo.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView userList;
    private RecyclerView.LayoutManager layoutManager;
    private UserAdapter mAdapter;
    private TextView text;
    private UserViewModel viewModel;
    private final String TAG = "MainActivity";
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        mAdapter.setUsers(users);
        viewModel.init();
        viewModel.getUsers().observe(this, new Observer<ApiResponse>() {

            @Override
            public void onChanged(@Nullable ApiResponse apiResponse) {
                mAdapter.setUsers(apiResponse.users);
            }
        });
    }

    public void initialize() {
        userList = (RecyclerView) findViewById(R.id.rUserList);
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new UserAdapter();
        /*text = (TextView) findViewById(R.id.tText);*/
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        // Setting LayoutManager
        userList.setLayoutManager(layoutManager);
        // Setting Adapter
        userList.setAdapter(mAdapter);

    }
}
