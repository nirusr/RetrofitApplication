package com.walmart.retrofitapplication.Helper;

import com.walmart.retrofitapplication.model.GoogleLatLng;
import com.walmart.retrofitapplication.model.Result;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by sgovind on 12/8/15.
 */
public interface IMyAPIEndpointInterface {
    @GET("json")
    Call<GoogleLatLng> getLatLng(@Query("address") String postcode);
}
