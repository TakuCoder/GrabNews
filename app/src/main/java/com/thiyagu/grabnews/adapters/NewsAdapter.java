package com.thiyagu.grabnews.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.thiyagu.grabnews.R;
import com.thiyagu.grabnews.Interfaces.ItemClickListener;
import com.thiyagu.grabnews.databinding.NewsFeedLayoutBinding;
import com.thiyagu.grabnews.models.news_pojo.Article;

import java.util.List;
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    ItemClickListener itemClickListener;
    private Context context;
    private List<Article> newsApiData;
    public NewsAdapter(Context context, List<Article> newsApiData, ItemClickListener itemClickListener) {
        this.context = context;
        this.newsApiData = newsApiData;
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsFeedLayoutBinding newsFeedLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.news_feed_layout, parent, false);
        return new ViewHolder(newsFeedLayoutBinding);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(newsApiData.get(position), itemClickListener, newsApiData.get(position).getUrl());
    }
    @Override
    public int getItemCount() {
        return newsApiData.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public NewsFeedLayoutBinding newsFeedLayoutBinding;
        public ViewHolder(NewsFeedLayoutBinding newsFeedLayoutBinding) {
            super(newsFeedLayoutBinding.getRoot());
            this.newsFeedLayoutBinding = newsFeedLayoutBinding;
        }
        public void bind(Article article, ItemClickListener itemClickListener, String url) {
            newsFeedLayoutBinding.setVariable(BR.news_data, article);
            newsFeedLayoutBinding.executePendingBindings();
            newsFeedLayoutBinding.rootCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClicked(url);
                }
            });
        }
    }
}
