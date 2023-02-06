package com.example.myapplication;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {
    private ProgressBar spinner;
    private WebView webview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.webView, new MainFragment())
//                    .commitNow();
//        }
        webview = (WebView) findViewById(R.id.webView);
        spinner = (ProgressBar)findViewById(R.id.progressBar);
        webview.setWebViewClient(new CustomWebViewClient());

//        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webview.loadUrl("file:///android_asset/index.html");
    }
    private class CustomWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView webview, String url, Bitmap favicon) {
            webview.setVisibility(webview.INVISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            spinner.setVisibility(View.GONE);

            view.setVisibility(webview.VISIBLE);
            super.onPageFinished(view, url);

        }

    }
    @Override
    public void onBackPressed(){
        if(webview != null && webview.canGoBack()){
            webview.goBack();
        }else{
            super.onBackPressed();
        }
    }
}