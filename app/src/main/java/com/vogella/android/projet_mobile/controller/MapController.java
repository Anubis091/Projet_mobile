package com.vogella.android.projet_mobile.controller;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vogella.android.projet_mobile.data.RestHerosAPI;
import com.vogella.android.projet_mobile.data.RestMapAPI;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.Map;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueMapResponse;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueResponse;
import com.vogella.android.projet_mobile.presentation.CaracteristiqueActivity;
import com.vogella.android.projet_mobile.presentation.MapActivity;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapController {private MapActivity activity;

    public MapController(MapActivity mapActivity) {
        this.activity = mapActivity;
    }
    public void onStart(Map map){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://menfoutiste.000webhostapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        final String id=""+map.getId();

        SharedPreferences detailCache = PreferenceManager.getDefaultSharedPreferences(activity);
        final SharedPreferences.Editor editor = detailCache.edit();

        RestMapAPI restMapAPI= retrofit.create(RestMapAPI.class);

        Call<RestCaracteristiqueMapResponse> call = restMapAPI.getMap(map.getId());
        call.enqueue(new Callback<RestCaracteristiqueMapResponse>() {
            @Override
            public void onResponse(Call<RestCaracteristiqueMapResponse> callCaracteristique,
                                   Response<RestCaracteristiqueMapResponse> response) {
                if(response.isSuccessful()) {
                    RestCaracteristiqueMapResponse restCaracteristiqueMapResponse = response.body();

                    activity.showDetailMap(restCaracteristiqueMapResponse);
                    Gson gson = new Gson();
                    String json = gson.toJson(restCaracteristiqueMapResponse);
                    editor.putString("detailCacheMap"+id, json);
                    editor.apply();
                    activity.showDetailMap(restCaracteristiqueMapResponse);
                } else {
                    System.out.println(response.errorBody());
                }


            }

            @Override
            public void onFailure(Call<RestCaracteristiqueMapResponse> call, Throwable t) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
                Gson gson = new Gson();
                String json = preferences.getString("detailCacheMap"+id, null);
                Type type = new TypeToken<RestCaracteristiqueMapResponse>() {}.getType();
                RestCaracteristiqueMapResponse restCaracteristiqueMapResponse = gson.fromJson(json, type);
                if(restCaracteristiqueMapResponse==null){
                    System.out.println(call);
                    System.out.println(t);
                    System.out.println("onFailure response body is null");
                    return;

                }
                activity.showDetailMap(restCaracteristiqueMapResponse);
            }
        });
    }


}