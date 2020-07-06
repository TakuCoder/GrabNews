package com.thiyagu.grabnews.DI.Module;
import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thiyagu.grabnews.Interfaces.NewsAPIInterface;
import com.thiyagu.grabnews.BuildConfig;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Module
public class NetModule {
    private String BaseUrl = "https://newsapi.org/v2/";
    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS).build();
        return okHttpClient;
    }
    @Provides
    @Singleton
    public Retrofit providesRetrofit(OkHttpClient okHttpClient, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .build();
        return retrofit;
    }
    @Provides
    @Singleton
    public Cache provideCache(Application application) {
        int size_cache = 10 * 1024 * 1024; //10MB
        Cache cache = null;
        try {
            cache = new Cache(new File(application.getCacheDir(), "cache"), size_cache);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cache;
    }
    @Singleton
    @Provides
    public Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        return gsonBuilder.create();
    }
    @Singleton
    @Provides
    public NewsAPIInterface provideNewsApiInterface(Retrofit retrofit) {
        return retrofit.create(NewsAPIInterface.class);
    }
}
