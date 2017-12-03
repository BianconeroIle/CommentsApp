package com.example.ilijaangeleski.cringle.di;

import com.example.ilijaangeleski.cringle.ui.MainActivity;

import dagger.Component;

/**
 * Created by Ilija Angeleski on 12/3/2017.
 */

@Component(modules = MainActivityModule.class,dependencies = MainComponent.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
