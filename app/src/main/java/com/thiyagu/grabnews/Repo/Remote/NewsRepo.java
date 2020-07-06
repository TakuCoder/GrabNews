package com.thiyagu.grabnews.Repo.Remote;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.thiyagu.grabnews.Interfaces.NewsAPIInterface;
import com.thiyagu.grabnews.BuildConfig;
import com.thiyagu.grabnews.DI.Component.NewsComponent;
import com.thiyagu.grabnews.BaseApplication;
import com.thiyagu.grabnews.Repo.Local.NewsDAO;
import com.thiyagu.grabnews.Utils.NetworkUtils;
import com.thiyagu.grabnews.models.news_pojo.Article;
import com.thiyagu.grabnews.models.news_pojo.NewsApiData;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class NewsRepo {
    MutableLiveData<List<Article>> newsData = new MutableLiveData<List<Article>>();
    @Inject
    NewsDAO newsDAO;
    @Inject
    NewsAPIInterface newsAPIInterface;
    @Inject
    public NewsRepo() {
        NewsComponent component = BaseApplication.baseApplication.component;
        component.inject(this);
    }
    public MutableLiveData<List<Article>> getNewsList() {
        if (!NetworkUtils.isInternetConnectivityAvailable()) {
            //fetchDbRecords();
            Log.e("Err","no internet found! will load data from local");
        } else {
            Call<NewsApiData> call = newsAPIInterface.FetchNews(BuildConfig.COUNTRY, BuildConfig.API_KEY);
            call.enqueue(new Callback<NewsApiData>() {
                @Override
                public void onResponse(Call<NewsApiData> call, Response<NewsApiData> response) {
                    if (response.isSuccessful()) {
                        int nuke_response = newsDAO.nuke();
                        if (nuke_response >= 0) {
                            for (Article article : response.body().getArticles()) {
                                newsDAO.insert(article);
                            }
                            //fetchDbRecords();
                        }
                    }
                }
                @Override
                public void onFailure(Call<NewsApiData> call, Throwable t) {
                    Log.e("Err", "Someone have a look here");
                }
            });
        }
        return newsData;
    }
//    private void fetchDbRecords() {
//        List<Article> articles = newsDAO.getNewsFromDatabase();
//        newsData.postValue(articles);
//    }

//        private void fetchDbRecords() {
//        List<Article> articles = newsDAO.getNewsFromDatabase();
//        newsData.postValue(articles);
//    }
}
