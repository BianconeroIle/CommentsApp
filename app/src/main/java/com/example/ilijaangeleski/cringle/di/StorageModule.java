package com.example.ilijaangeleski.cringle.di;

import android.content.Context;

import com.example.ilijaangeleski.cringle.manager.SharedPreferencesStoreManager;
import com.example.ilijaangeleski.cringle.manager.StorageManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 12/2/2017.
 */
@Module
public class StorageModule {

    @Provides
    StorageManager providesStorageManager(Context context){
        return new SharedPreferencesStoreManager(context);
    }
}
