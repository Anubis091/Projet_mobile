package com.vogella.android.projet_mobile.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.android.projet_mobile.CaracteristiqueActivity;
import com.vogella.android.projet_mobile.model.Caracteristique;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueAPI;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueResponse;
import com.vogella.android.projet_mobile.model.RestHerosAPI;
import com.vogella.android.projet_mobile.model.RestHerosResponse;

import java.util.List;

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
    public void onStart(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://menfoutiste.000webhostapp.com/api/") //a modifier
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestCaracteristiqueAPI restCaracteristiqueAPI= retrofit.create(RestCaracteristiqueAPI.class);

        Call<RestCaracteristiqueResponse> call = restCaracteristiqueAPI .getCaracteristique();
        call.enqueue(new Callback<RestCaracteristiqueResponse>() {
            @Override
            public void onResponse(Call<RestCaracteristiqueResponse> call,
                                   Response<RestCaracteristiqueResponse> response) {
                RestCaracteristiqueResponse restCaracteristiqueResponse = response.body();
                List<Hero> listHero= restCaracteristiqueResponse.getCaracteristiques();
                activity.showList(listHero);
            }

            @Override
            public void onFailure(Call<RestCaracteristiqueResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }
}