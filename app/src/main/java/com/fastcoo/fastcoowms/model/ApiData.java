package com.fastcoo.fastcoowms.model;

import io.reactivex.Single;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiData {
    @GET("Picker/auth_login?")
    Call<Loginmodel> login(@Query("email") String email, @Query("password") String password);
}
