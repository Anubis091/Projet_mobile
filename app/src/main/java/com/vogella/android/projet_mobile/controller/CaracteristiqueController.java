package com.vogella.android.projet_mobile.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.android.projet_mobile.data.RestHerosAPI;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueResponse;
import com.vogella.android.projet_mobile.presentation.CaracteristiqueActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CaracteristiqueController {
    private CaracteristiqueActivity activity;

    public CaracteristiqueController(CaracteristiqueActivity caracteristiqueActivity) {
        this.activity = caracteristiqueActivity;
    }
    public void onStart(Hero hero){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://menfoutiste.000webhostapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestHerosAPI restHerosAPI= retrofit.create(RestHerosAPI.class);

        Call<RestCaracteristiqueResponse> call = restHerosAPI.getCaracter(hero.getId());
        call.enqueue(new Callback<RestCaracteristiqueResponse>() {
            @Override
            public void onResponse(Call<RestCaracteristiqueResponse> callCaracteristique,
                                   Response<RestCaracteristiqueResponse> response) {
                RestCaracteristiqueResponse restCaracteristiqueResponse = response.body();

              activity.showDetail(restCaracteristiqueResponse);


            }

            @Override
            public void onFailure(Call<RestCaracteristiqueResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }
}