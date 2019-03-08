package com.vogella.android.projet_mobile.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.android.projet_mobile.model.Caracteristique;
import com.vogella.android.projet_mobile.presentation.CaracteristiqueActivity;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.data.RestCaracteristiqueAPI;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueResponse;

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
    Hero hero = new Hero();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(hero.getUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestCaracteristiqueAPI restCaracteristiqueAPI= retrofit.create(RestCaracteristiqueAPI.class);

        Call<RestCaracteristiqueResponse> call = restCaracteristiqueAPI .getCaracter();
        call.enqueue(new Callback<RestCaracteristiqueResponse>() {
            @Override
            public void onResponse(Call<RestCaracteristiqueResponse> callCaracteristique,
                                   Response<RestCaracteristiqueResponse> response) {
                RestCaracteristiqueResponse restCaracteristiqueResponse = response.body();
               String id= restCaracteristiqueResponse.getId();
               String classe=restCaracteristiqueResponse.getClasse();
               String img=restCaracteristiqueResponse.getImg();
               String img_min=restCaracteristiqueResponse.getImg_min();
               String caracteristique=restCaracteristiqueResponse.getCaracteristiques();
               String nom=restCaracteristiqueResponse.getNom();
               String A=restCaracteristiqueResponse.getA();
               String Z=restCaracteristiqueResponse.getZ();
               String E=restCaracteristiqueResponse.getE();
               String D=restCaracteristiqueResponse.getD();
               String talent1=restCaracteristiqueResponse.getTalents1();
               String talent4=restCaracteristiqueResponse.getTalents4();
               String talent7=restCaracteristiqueResponse.getTalents7();
               String talent10=restCaracteristiqueResponse.getTalents10();
               String talent13=restCaracteristiqueResponse.getTalents13();
               String talent16=restCaracteristiqueResponse.getTalents16();
               String talent20=restCaracteristiqueResponse.getTalents20();
                activity.showList(caracteristique);
            }

            @Override
            public void onFailure(Call<RestCaracteristiqueResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }
}