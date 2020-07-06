package com.thiyagu.grabnews;
import android.app.Application;

import com.thiyagu.grabnews.DI.Component.DaggerNewsComponent;
import com.thiyagu.grabnews.DI.Component.NewsComponent;
import com.thiyagu.grabnews.DI.Module.AppModule;
import com.thiyagu.grabnews.DI.Module.DatabaseModule;
import com.thiyagu.grabnews.DI.Module.NetModule;
public class BaseApplication extends Application {
    public static BaseApplication baseApplication;
    public NewsComponent component;
    public static BaseApplication getBaseApplication() {
        return baseApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        component = DaggerNewsComponent.builder().appModule(new AppModule(this)).databaseModule(new DatabaseModule(this)).netModule(new NetModule()).build();
    }
}
