package com.example.androidproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.example.androidproject.model.Technologies;
import com.example.androidproject.model.RestTechnologiesResponse;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private com.example.androidproject.MainActivity activity;

    private RestTechnologiesApi restTechnologiesApi;

    public MainController(com.example.androidproject.MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/technologies")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restTechnologiesApi = retrofit.create(RestTechnologiesApi.class);

        if(hasDataInDataBase()){
            List<Technologies> technologiesList = getListFromDataBase();
            activity.showList(technologiesList);
        }else{
            makeApiCall();
        }
    }

    private void makeApiCall() {
        Call<RestTechnologiesResponse> call = restTechnologiesApi.getListTechnologies();
        call.enqueue(new Callback<RestTechnologiesResponse>() {
            @Override
            public void onResponse(Call<RestTechnologiesResponse> call,
                                   Response<RestPokemonResponse> response) {
                RestTechnologiesResponse restTechnologiesResponse = response.body();
                List<Technologies> listPokemon = restTechnologiesResponse.getResults();
                storeData(listTechnologies);
                activity.showList(listTechnologies);
            }

            @Override
            public void onFailure(Call<RestTechnologiesResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }

    private void storeData(List<Technologies> listTechnologies) {
        //TODO

    }

    private List<Technologies> getListFromDataBase() {
        //TODO Implement With real logic
        return new ArrayList<>();
    }

    private boolean hasDataInDataBase() {
        //TODO Implement With real logic
        return true;
    }
}
