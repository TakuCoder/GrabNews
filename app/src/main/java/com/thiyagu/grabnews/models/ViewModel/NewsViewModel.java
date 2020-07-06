package com.thiyagu.grabnews.models.ViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thiyagu.grabnews.Interfaces.RxSingleSchedulers;
import com.thiyagu.grabnews.BaseApplication;
import com.thiyagu.grabnews.Repo.Local.NewsDAO;
import com.thiyagu.grabnews.Repo.Remote.NewsRepo;
import com.thiyagu.grabnews.models.news_pojo.Article;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
public class NewsViewModel extends ViewModel {
    CompositeDisposable disposable;
    MutableLiveData<List<Article>> article_data;
    @Inject
    NewsRepo newsRepo;
    @Inject
    RxSingleSchedulers rxSingleSchedulers;
    @Inject
    NewsDAO newsDAO;
    public NewsViewModel() {
        this.article_data = new MutableLiveData<>();
        BaseApplication.baseApplication.component.inject(this);
        disposable = new CompositeDisposable();
    }
    //    public MutableLiveData<List<Article>> getList() {
//        article_data = newsRepo.getNewsList();
//        return article_data;
//    }
    public void HitApi() {
        article_data = newsRepo.getNewsList();
    }
    public MutableLiveData<List<Article>> GetData() {
        newsDAO.getNewsFromDatabase().subscribe(articles -> article_data.postValue(articles)); //fetching data using Rx
        return article_data;
    }
    void addMockDataToNewsViewModel(List<Article> mockData) {
        article_data.postValue(mockData);
    }
}
