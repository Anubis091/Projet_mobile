package com.vogella.android.projet_mobile.data;

import com.vogella.android.projet_mobile.model.RestCaracteristiqueResponse;
import com.vogella.android.projet_mobile.model.RestHerosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestHerosAPI {
    @GET("get_heros?limit=100")
    Call<RestHerosResponse> getListHeros();

    @GET("get_heros/{id}")
    Call<RestCaracteristiqueResponse> getCaracter(@Path("id") int id);
}
