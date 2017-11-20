package com.pialkanti.architecuredemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pialkanti.architecuredemo.R;
import com.pialkanti.architecuredemo.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pial Kanti Samadder<pialkanti2012@gmail.com>
 * Date: 11/18/2017
 * Time: 12:04 PM
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<User> users;

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater mInflater = LayoutInflater.from(context);
        View view = mInflater.inflate(R.layout.row_main, parent, false);
        ViewHolder mHolder = new ViewHolder(view, context);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (users == null) {
            return 0;
        } else {
            return users.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        private TextView mName;
        private TextView mAddress;

        public ViewHolder(View view, Context context) {
            super(view);
            this.context = context;
            mName = (TextView) view.findViewById(R.id.tName);
            mAddress = (TextView) view.findViewById(R.id.tAddress);
        }

        public void bind(int position) {
            User user = users.get(position);
            mName.setText(user.getName());
            mAddress.setText(user.getAddress());
        }
    }
}
