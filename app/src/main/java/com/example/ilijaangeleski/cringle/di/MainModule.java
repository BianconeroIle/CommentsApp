package com.example.ilijaangeleski.cringle.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ilijaangeleski.cringle.api.NetworkApi;
import com.example.ilijaangeleski.cringle.manager.MainManager;
import com.example.ilijaangeleski.cringle.manager.SharedPreferencesStoreManager;
import com.example.ilijaangeleski.cringle.manager.StorageManager;
import com.example.ilijaangeleski.cringle.presenter.MainPresenter;
import com.example.ilijaangeleski.cringle.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 11/27/2017.
 */
@Module
public class MainModule {
    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences("SharedPref", Context.MODE_PRIVATE);
    }

    @Provides
    SharedPreferencesStoreManager provideSharedPrefStoreManager(Context context) {
        return new SharedPreferencesStoreManager(context);
    }

    @Provides
    MainManager provideMainManager(NetworkApi api, StorageManager storageManager) {
        return new MainManager(api, storageManager);
    }

    @Provides
    MainPresenter providesMainPresenter() {
        return new MainPresenter(view);
    }
}
