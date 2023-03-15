package com.example.logindatainsert;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelActivity {

    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("phone")
    @Expose
    private String phone;


    @SerializedName("response")
    @Expose
    private String response;


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getResponse() {
        return response;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
