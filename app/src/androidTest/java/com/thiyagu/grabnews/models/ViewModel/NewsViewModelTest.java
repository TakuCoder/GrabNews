package com.thiyagu.grabnews.models.ViewModel;
import com.thiyagu.grabnews.models.news_pojo.Article;
import com.thiyagu.grabnews.models.news_pojo.Source;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class NewsViewModelTest {
    NewsViewModel viewModel;
    @Test
    public void addMokcDataToNewsViewModel() {
        List<Article> article_list = new ArrayList<>();


        Article article = new Article();
        article.setAuthor("TEST");
        article.setContent("TEST");
        article.setDescription("TEST");
        article.setPublishedAt("TEST");
        Source source = new Source();
        source.setId(UUID.randomUUID().toString().substring(0,4));
        source.setName("TEST");
        article.setSource(source);
        article.setTitle("TEST");
        article.setUrl("http://test.com");
        article.setUrlToImage("http://test.com");

        article_list.add(article);

        viewModel.addMockDataToNewsViewModel(article_list);
    }
}