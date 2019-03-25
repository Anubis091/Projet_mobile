package com.vogella.android.projet_mobile.controller;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vogella.android.projet_mobile.data.RestHerosAPI;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.RestHerosResponse;
import com.vogella.android.projet_mobile.presentation.MainActivity;

import java.lang.reflect.Type;
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

        SharedPreferences herosCache = PreferenceManager.getDefaultSharedPreferences(activity);
        final SharedPreferences.Editor editor = herosCache.edit();

        RestHerosAPI restHerosApi = retrofit.create(RestHerosAPI.class);

        Call<RestHerosResponse> call = restHerosApi .getListHeros();
        call.enqueue(new Callback<RestHerosResponse>() {
            @Override
            public void onResponse(Call<RestHerosResponse> call,
                                   Response<RestHerosResponse> response) {
                if(response.isSuccessful()) {
                RestHerosResponse restHerosResponse = response.body();
                List<Hero> listHero= restHerosResponse.getResults();
                activity.showList(listHero);

                    Gson gson = new Gson();
                    String json = gson.toJson(listHero);
                    editor.putString("herosCache", json);
                    editor.apply();
                    activity.showList(listHero);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RestHerosResponse> call, Throwable t) {

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
                Gson gson = new Gson();
                String json = preferences.getString("herosCache", null);
                Type type = new TypeToken<List<Hero>>() {}.getType();
                List<Hero> listHero = gson.fromJson(json, type);
                if(listHero==null){
                    System.out.println(call);
                    System.out.println(t);
                    System.out.println("onFailure response body is null");
                    return;

                }
                activity.showList(listHero);
            }
        });
    }
}