package com.thiyagu.grabnews.DI.Module;
import com.thiyagu.grabnews.Interfaces.RxSingleSchedulers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module
public class RxModule {

    @Singleton
    @Provides
    public RxSingleSchedulers providesScheduler() {
        return RxSingleSchedulers.DEFAULT;
    }
}
