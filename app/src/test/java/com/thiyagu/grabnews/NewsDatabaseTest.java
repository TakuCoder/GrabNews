package com.thiyagu.grabnews;
import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import com.thiyagu.grabnews.Repo.Local.NewsDatabase;
import com.thiyagu.grabnews.Repo.Local.NewsDAO;

import org.junit.After;
import org.junit.Before;
public class NewsDatabaseTest {
    private NewsDatabase newsDataBase;
    Context instrumentationContext;
    Context context;
    public NewsDAO getNewsDAO() {
        return newsDataBase.getNewsDao();
    }
    @Before
    public void init() {
        context = ApplicationProvider.getApplicationContext();
        instrumentationContext = InstrumentationRegistry.getInstrumentation().getContext();
        newsDataBase = Room.inMemoryDatabaseBuilder(
                instrumentationContext,
                NewsDatabase.class
        ).build();
    }
    @After
    public void finish() {
        newsDataBase.close();
    }
}