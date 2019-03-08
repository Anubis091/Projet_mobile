package com.vogella.android.projet_mobile.data;

import com.vogella.android.projet_mobile.model.RestCaracteristiqueResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestCaracteristiqueAPI {
    @GET("")
    Call<RestCaracteristiqueResponse> getCaracter();
}
