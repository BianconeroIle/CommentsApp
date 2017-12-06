package com.example.ilijaangeleski.cringle.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 12/2/2017.
 */
@Module
public class ApplicationModule {
    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }
}
