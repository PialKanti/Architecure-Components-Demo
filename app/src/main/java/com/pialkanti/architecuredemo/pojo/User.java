package com.pialkanti.architecuredemo.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * @author: Pial Kanti Samadder<pialkanti2012@gmail.com>
 * Date: 11/17/2017
 * Time: 5:44 PM
 */

public class User {
    @SerializedName("name")
    String name;
    @SerializedName("address")
    String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
