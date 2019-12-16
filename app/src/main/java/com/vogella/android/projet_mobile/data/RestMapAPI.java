package com.vogella.android.projet_mobile.data;

import com.vogella.android.projet_mobile.model.RestCaracteristiqueMapResponse;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueResponse;
import com.vogella.android.projet_mobile.model.RestMapResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestMapAPI {

    @GET("get_maps")
    Call<RestMapResponse> getListMap();

    @GET("get_maps/{id}")
    Call<RestCaracteristiqueMapResponse> getMap(@Path("id") int id);
}
