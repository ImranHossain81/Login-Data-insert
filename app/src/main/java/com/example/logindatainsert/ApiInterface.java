package com.example.logindatainsert;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("insert_std.php")
    Call<ModelActivity> insertActivity (@Body ModelActivity modelActivity);

    @POST("login.php")
    Call<ModelActivity> login (@Body ModelActivity modelActivity);

   @GET("getData.php")
   Call<List<ModelActivity>> getAllData();
}
