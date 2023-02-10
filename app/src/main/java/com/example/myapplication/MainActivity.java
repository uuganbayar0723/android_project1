package com.example.myapplication;

import android.os.Bundle;
import android.view.Gravity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.navigation.NavigationView;

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

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);



//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.webView, new MainFragment())
//                    .commitNow();
//        }
//        webview = (WebView) findViewById(R.id.webView);
//        spinner = (ProgressBar)findViewById(R.id.progressBar);
//        webview.setWebViewClient(new CustomWebViewClient());
//
////        webview.getSettings().setJavaScriptEnabled(true);
//        webview.getSettings().setDomStorageEnabled(true);
//        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
//        webview.loadUrl("file:///android_asset/index.html");
    }
//    private class CustomWebViewClient extends WebViewClient {
//
//        @Override
//        public void onPageStarted(WebView webview, String url, Bitmap favicon) {
//            webview.setVisibility(webview.INVISIBLE);
//        }
//
//        @Override
//        public void onPageFinished(WebView view, String url) {
//
//            spinner.setVisibility(View.GONE);
//
//            view.setVisibility(webview.VISIBLE);
//            super.onPageFinished(view, url);
//
//        }
//
//    }
//    @Override
//    public void onBackPressed(){
//        if(webview != null && webview.canGoBack()){
//            webview.goBack();
//        }else{
//            super.onBackPressed();
//        }
//    }
}