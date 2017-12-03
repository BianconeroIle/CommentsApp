package com.example.ilijaangeleski.cringle.di;

import android.app.Application;

/**
 * Created by Ilija Angeleski on 12/2/2017.
 */

public class MyApp extends Application {
    private MainComponent mainComponent;
    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mainComponent = DaggerMainComponent.builder()
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .networkModule(new NetworkModule())
                .storageModule(new StorageModule())
                .build();
    }

    public static MyApp getApp() {
        return app;
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }

}
