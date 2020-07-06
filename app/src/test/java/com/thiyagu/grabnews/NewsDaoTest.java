package com.thiyagu.grabnews;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.thiyagu.grabnews.Repo.Local.NewsDatabase;
import com.thiyagu.grabnews.Repo.Local.NewsDAO;
import com.thiyagu.grabnews.models.news_pojo.Article;
import com.thiyagu.grabnews.models.news_pojo.Source;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.List;
import java.util.concurrent.Executors;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
@RunWith(AndroidJUnit4.class)
public class NewsDaoTest extends NewsDatabaseTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    private NewsDatabase roomDatabase;
    private NewsDAO newsDAO;
    @Mock
    private Observer<List<Article>> observer;

    @Test
    public void insertReadDelete() throws InterruptedException {
        Article article = new Article();
        article.setAuthor("TEST");
        article.setContent("TEST");
        article.setDescription("TEST");
        article.setPublishedAt("TEST");
        Source source = new Source();
        source.setId(1234);
        source.setName("TEST");
        article.setSource(source);
        article.setTitle("TEST");
        article.setUrl("http://test.com");
        article.setUrlToImage("http://test.com");

        Executors.newSingleThreadExecutor().execute(() ->{
            getNewsDAO().insert();

            Disposable read_article = getNewsDAO().getNewsFromDatabase().subscribe(articles -> {
                assertEquals(article.getAuthor(), articles.get(0).getAuthor());
                assertEquals(article.getContent(), articles.get(0).getContent());
                assertEquals(article.getDescription(), articles.get(0).getDescription());
            });
            assertNotNull(read_article);



            getNewsDAO().delete(article);
            //insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes());
            //assertEquals(0, insertedNotes.size());

        }   );


    }
}