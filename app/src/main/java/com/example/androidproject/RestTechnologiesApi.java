package com.example.androidproject;

import com.example.androidproject.model.RestTechnologiesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestTechnologiesApi {

    @GET("technologies")
    Call<RestTechnologiesResponse> getListTechnologiesn();
}