package com.thiyagu.grabnews.Repo.Local;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.thiyagu.grabnews.models.news_pojo.Article;
@androidx.room.Database(entities = {Article.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class NewsDatabase extends RoomDatabase {
    public abstract NewsDAO getNewsDao(); //provide news dao
}
