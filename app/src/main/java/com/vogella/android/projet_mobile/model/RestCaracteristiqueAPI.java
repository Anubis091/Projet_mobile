package com.vogella.android.projet_mobile.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestCaracteristiqueAPI {
    @GET("")
    Call<RestCaracteristiqueResponse> getCaracteristique();
}
