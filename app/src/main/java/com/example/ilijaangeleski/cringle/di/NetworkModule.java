package com.example.ilijaangeleski.cringle.di;

import com.example.ilijaangeleski.cringle.api.NetworkApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilija Angeleski on 12/2/2017.
 */
@Module
public class NetworkModule {

    @Provides
    Retrofit providesRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(NetworkApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    NetworkApi providesNetworkApi(Retrofit retrofit) {
        return retrofit.create(NetworkApi.class);
    }
}
