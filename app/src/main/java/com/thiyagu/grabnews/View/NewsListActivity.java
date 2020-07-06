package com.thiyagu.grabnews.View;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thiyagu.grabnews.Interfaces.ItemClickListener;
import com.thiyagu.grabnews.R;
import com.thiyagu.grabnews.adapters.NewsAdapter;
import com.thiyagu.grabnews.databinding.ActivityMainBinding;
import com.thiyagu.grabnews.models.ViewModel.NewsViewModel;
import com.thiyagu.grabnews.models.news_pojo.Article;

import java.util.List;
public class NewsListActivity extends AppCompatActivity implements ItemClickListener {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performBinding();
        getNews();
    }
    private void performBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
    private void getNews() {
        NewsViewModel newsViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(NewsViewModel.class);
        newsViewModel.HitApi();
        newsViewModel.GetData().observe(this, articles -> {
            setAdapter(articles);
        });
    }
    void setAdapter(List<Article> newsApiData) {
        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter adapter = new NewsAdapter(this, newsApiData, this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClicked(String url) {
        Intent intent = new Intent(this, NewsDetailsActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}