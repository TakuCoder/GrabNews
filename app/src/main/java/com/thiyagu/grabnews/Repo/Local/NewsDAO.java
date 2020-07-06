package com.thiyagu.grabnews.Repo.Local;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.thiyagu.grabnews.models.news_pojo.Article;

import java.util.List;

import io.reactivex.Flowable;
@Dao
public interface NewsDAO {
    @Insert
    public void insert(Article... news);

    @Update
    public void update(Article... body);

    @Delete
    public void delete(Article body);

    @Query("select * from articles")
    public Flowable<List<Article>> getNewsFromDatabase();

    @Query("delete from articles")
    public int nuke();
}
