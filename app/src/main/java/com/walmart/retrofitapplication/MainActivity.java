package com.walmart.retrofitapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.walmart.retrofitapplication.Helper.IMyAPIEndpointInterface;
import com.walmart.retrofitapplication.model.GoogleLatLng;
import com.walmart.retrofitapplication.model.Result;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* Stetho.initialize(
                Stetho.newInitializerBuilder(this).enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build()


        );

        OkHttpClient client  = new OkHttpClient();
        client.networkInterceptors().add(new StethoInterceptor());
*/


        OkHttpClient dClient = new OkHttpClient();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        dClient.interceptors().add(interceptor);

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).client(dClient).build();



        IMyAPIEndpointInterface apiService = retrofit.create(IMyAPIEndpointInterface.class);
        Call<GoogleLatLng> call = apiService.getLatLng("94555");

        call.enqueue(new Callback<GoogleLatLng>() {
            @Override
            public void onResponse(Response<GoogleLatLng> response, Retrofit retrofit) {
                int statusCode = response.code();
                GoogleLatLng latLng = response.body();
                Log.v("Lat/Lng:", latLng.getResults().get(0).getGeometry().getLocation().getLat()+"");
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}
