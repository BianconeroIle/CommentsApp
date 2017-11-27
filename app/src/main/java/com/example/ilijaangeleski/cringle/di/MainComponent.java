package com.example.ilijaangeleski.cringle.di;

import com.example.ilijaangeleski.cringle.ui.MainActivity;

import dagger.Component;

/**
 * Created by Ilija Angeleski on 11/27/2017.
 */

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
