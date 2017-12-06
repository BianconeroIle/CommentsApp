package com.example.ilijaangeleski.cringle.di;

import android.content.Context;

import com.example.ilijaangeleski.cringle.api.NetworkApi;
import com.example.ilijaangeleski.cringle.manager.StorageManager;

import dagger.Component;

/**
 * Created by Ilija Angeleski on 11/27/2017.
 */

@Component(modules = {NetworkModule.class, StorageModule.class, ApplicationModule.class})
public interface MainComponent {
    NetworkApi networkApi();

    StorageManager storageManager();

    Context context();
}
