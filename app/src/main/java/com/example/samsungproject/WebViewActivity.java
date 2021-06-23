package com.example.samsungproject;

import android.app.ActionBar;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
//        ActionBar ab = getActionBar();
//        ab.hide();

        final WebView wv = findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);

        wv.setWebChromeClient(new WebChromeClient());

        String folderPath = "file:///android_asset/";
        String fileName = "index.html";

        String file = folderPath + fileName;

        wv.loadUrl(file);
    }
}