package com.vogella.android.projet_mobile.controller;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vogella.android.projet_mobile.data.RestHerosAPI;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueResponse;
import com.vogella.android.projet_mobile.presentation.CaracteristiqueActivity;

import java.lang.reflect.Type;

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
        final String id=""+hero.getId();

        SharedPreferences detailCache = PreferenceManager.getDefaultSharedPreferences(activity);
        final SharedPreferences.Editor editor = detailCache.edit();

        RestHerosAPI restHerosAPI= retrofit.create(RestHerosAPI.class);

        Call<RestCaracteristiqueResponse> call = restHerosAPI.getCaracter(hero.getId());
        call.enqueue(new Callback<RestCaracteristiqueResponse>() {
            @Override
            public void onResponse(Call<RestCaracteristiqueResponse> callCaracteristique,
                                   Response<RestCaracteristiqueResponse> response) {
                if(response.isSuccessful()) {
                RestCaracteristiqueResponse restCaracteristiqueResponse = response.body();

              activity.showDetail(restCaracteristiqueResponse);
                    Gson gson = new Gson();
                    String json = gson.toJson(restCaracteristiqueResponse);
                    editor.putString("detailCache"+id, json);
                    editor.apply();
                    activity.showDetail(restCaracteristiqueResponse);
                } else {
                    System.out.println(response.errorBody());
                }


            }

            @Override
            public void onFailure(Call<RestCaracteristiqueResponse> call, Throwable t) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
                Gson gson = new Gson();
                String json = preferences.getString("detailCache"+id, null);
                Type type = new TypeToken<RestCaracteristiqueResponse>() {}.getType();
                RestCaracteristiqueResponse restCaracteristiqueResponse = gson.fromJson(json, type);
                if(restCaracteristiqueResponse==null){
                    System.out.println(call);
                    System.out.println(t);
                    System.out.println("onFailure response body is null");
                    return;

                }
                activity.showDetail(restCaracteristiqueResponse);
            }
        });
    }
}