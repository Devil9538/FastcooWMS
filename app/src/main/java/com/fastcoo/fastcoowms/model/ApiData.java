package com.fastcoo.fastcoowms.model;

import java.util.HashMap;

import io.reactivex.Single;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiData {
    @POST("customerLogin")
    Call<Loginmodel> login(@Body HashMap<String, String> login);

    @POST("getScheduleWmsInventory")
    Call<Schedule_Status> schedule_wms(@Body HashMap<String,String> schedule);

    @POST("getHoldWmsInventory")
    Call<OnHold_Status> onHold_wms(@Body HashMap<String,String> onHold);
}
