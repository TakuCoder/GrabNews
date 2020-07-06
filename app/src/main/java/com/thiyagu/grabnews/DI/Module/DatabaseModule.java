package com.thiyagu.grabnews.DI.Module;
import android.content.Context;

import androidx.room.Room;

import com.thiyagu.grabnews.Repo.Local.NewsDatabase;
import com.thiyagu.grabnews.Repo.Local.NewsDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module
public class DatabaseModule {
    public final Context context;
    public DatabaseModule(Context context) {
        this.context = context;
    }
    @Provides
    @Singleton
    NewsDatabase providesDatabase() {
        return Room.databaseBuilder(context, NewsDatabase.class, "news_data_db")
                .allowMainThreadQueries()   //Allows room to do operation on main thread
                .build();
    }
    @Singleton
    @Provides
    NewsDAO provideInfoDAO(NewsDatabase newsDatabase_) {
        return newsDatabase_.getNewsDao();
    }
}
