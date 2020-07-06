package com.thiyagu.grabnews.Interfaces;
import com.thiyagu.grabnews.models.news_pojo.NewsApiData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface NewsAPIInterface {
    @GET("top-headlines")
    Call<NewsApiData> FetchNews(@Query("country") String country, @Query("apiKey") String apiKey);
}
