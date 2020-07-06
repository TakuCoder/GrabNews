package com.thiyagu.grabnews.adapters;


import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.thiyagu.grabnews.R;

public class BindingAdapters {
    @BindingAdapter("android:setImage")
    public static void setImageFromUrl(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).apply(new RequestOptions().placeholder(R.drawable.placeholder)).into(view);
    }
}
