package com.vogella.android.projet_mobile.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestHerosAPI {
    @GET("changes/")
    Call<RestHerosResponse>getListHeros();
}
