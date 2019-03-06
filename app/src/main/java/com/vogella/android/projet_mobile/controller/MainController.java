package com.vogella.android.projet_mobile.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.android.projet_mobile.MainActivity;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.RestHerosAPI;
import com.vogella.android.projet_mobile.model.RestHerosResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {
    private MainActivity activity;

    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }
    public void onStart(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://menfoutiste.000webhostapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestHerosAPI restHerosApi = retrofit.create(RestHerosAPI.class);

        Call<RestHerosResponse> call = restHerosApi .getListHeros();
        call.enqueue(new Callback<RestHerosResponse>() {
            @Override
            public void onResponse(Call<RestHerosResponse> call,
                                   Response<RestHerosResponse> response) {
                RestHerosResponse restHerosResponse = response.body();
                List<Hero> listHero= restHerosResponse.getResults();
                activity.showList(listHero);
            }

            @Override
            public void onFailure(Call<RestHerosResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }
}