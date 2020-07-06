package com.thiyagu.grabnews.View;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.thiyagu.grabnews.R;
import com.thiyagu.grabnews.databinding.ActivityDetailedViewBinding;
public class NewsDetailsActivity extends AppCompatActivity {
    ActivityDetailedViewBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performBinding();
        this.setTitle(getString(R.string.detailed_view_name));
        initWebView();
        loadwebview();
    }
    private void initWebView() {
        binding.webview.getSettings().setLoadsImagesAutomatically(true);
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        binding.webview.getSettings().setDomStorageEnabled(true);
        binding.webview.getSettings().setSupportZoom(true);
        binding.webview.getSettings().setBuiltInZoomControls(true);
        binding.webview.getSettings().setDisplayZoomControls(false);
        binding.webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.webview.setWebViewClient(new WebViewClient());
    }
    private void loadwebview() {
        String url = getIntent().getStringExtra(getString(R.string.url_key));
        binding.webview.loadUrl(url);
    }
    private void performBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detailed_view);
    }
}
