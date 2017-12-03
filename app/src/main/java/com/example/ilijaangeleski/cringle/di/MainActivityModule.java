package com.example.ilijaangeleski.cringle.di;

import com.example.ilijaangeleski.cringle.api.NetworkApi;
import com.example.ilijaangeleski.cringle.manager.MainManager;
import com.example.ilijaangeleski.cringle.manager.StorageManager;
import com.example.ilijaangeleski.cringle.presenter.MainPresenter;
import com.example.ilijaangeleski.cringle.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 12/3/2017.
 */
@Module
public class MainActivityModule {
    private MainView view;

    public MainActivityModule(MainView view) {
        this.view = view;
    }

    @Provides
    MainPresenter provideMainPresenter(MainManager mainManager) {
        return new MainPresenter(view, mainManager);
    }

    @Provides
    MainManager providesMainManager(NetworkApi api, StorageManager storageManager) {
        return new MainManager(api, storageManager);
    }

}
