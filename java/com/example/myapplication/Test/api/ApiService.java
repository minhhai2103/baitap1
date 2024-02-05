package com.example.myapplication.Test.api;

import com.example.myapplication.Test.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface ApiService {

            // Link API: http://nguyenvantuanolivas.mooo.com/api2/customer
            Gson gson = new GsonBuilder()
             .setDateFormat("")
            .create ();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://nguyenvantuanolivas.mooo.com/api2/")
            .addConverterFactory (GsonConverterFactory.create(gson))
            .build()
            .create (ApiService.class);
    @GET("users")
            Call<List<User>> getLiatUsers (@Query ("fbclid") String key);

}
