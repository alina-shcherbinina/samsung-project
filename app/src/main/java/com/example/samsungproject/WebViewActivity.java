package com.example.samsungproject;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "TAG";
    Button font_btn, plus_btn, minus_btn, theme_btn;
    WebView wv;
    String state_font = "Helvetica";
    String theme = "night";
    LinearLayout btn_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_webview);
//        ActionBar ab = getActionBar();
//        ab.hide();

        wv = findViewById(R.id.wv);

        font_btn = findViewById(R.id.font_btn);
        font_btn.setOnClickListener(this);

        plus_btn = findViewById(R.id.plus_btn);
        plus_btn.setOnClickListener(this);

        minus_btn = findViewById(R.id.minus_btn);
        minus_btn.setOnClickListener(this);

        theme_btn = findViewById(R.id.theme_btn);
        theme_btn.setOnClickListener(this);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebChromeClient(new WebChromeClient());

        btn_layout = findViewById(R.id.btn_layout);

        String folderPath = "file:///android_asset/";
        String fileName = "index.html";

        String file = folderPath + fileName;

        wv.loadUrl(file);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.font_btn:
                changeFont();
                break;
            case R.id.plus_btn:
                makeFontBigger();
                break;
            case R.id.minus_btn:
                makeFontSmaller();
                break;
            case R.id.theme_btn:
                changeTheme();
                break;
        }
    }

    // change font
    public void changeFont() {
        String wv_txt = "Georgia";

        switch (state_font) {
            case "Georgia":
                state_font = "Helvetica";
                wv_txt = "Georgia";
                font_btn.setText("шрифт: Georgia");
                break;
            case "Helvetica":
                state_font = "Georgia";
                wv_txt = "Helvetica";
                font_btn.setText("шрифт: Helvetica");
                break;
        }

        wv.evaluateJavascript("javascript:ChangeFont(\"" + wv_txt + "\")", null);
        Log.d(TAG, "setFont: " + wv_txt);

    }


    //change text size
    public void makeFontBigger() {
        WebSettings settings = wv.getSettings();
        if (settings.getTextZoom() >= 170) {
            Toast.makeText(getApplicationContext(),"Max text zoom",Toast.LENGTH_SHORT).show();
        } else {
            settings.setTextZoom(settings.getTextZoom() + 10);
        }
    }

    public void makeFontSmaller() {
        WebSettings settings = wv.getSettings();
        if (settings.getTextZoom() <= 80) {
            Toast.makeText(getApplicationContext(),"Min text zoom",Toast.LENGTH_SHORT).show();
        } else {
            settings.setTextZoom(settings.getTextZoom() - 10);
        }
    }
    // change theme
    public void changeTheme() {

        String txt_color = "#04040c";
        String bg_color = "#FFFFFF";
        String ct_color = "#6d809f";

        switch (theme) {
            case "day":
                theme = "night";
                txt_color = "#04040c";
                bg_color = "#FFFFFF";
                ct_color = "#FFFFFF";
                btn_layout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                theme_btn.setText("тема: день");
                break;
            case "night":
                theme = "day";
                txt_color = "#FFFFFF";
                bg_color = "#04040c";
                ct_color = "#6d809f";
                btn_layout.setBackgroundColor(Color.parseColor("#04040c"));
                theme_btn.setText("тема: ночь");
                break;
        }

        wv.evaluateJavascript("javascript:ChangeTheme(\"" + txt_color + "\" , \""+ bg_color  +"\", \"" + ct_color +"\")", null);
        Log.d(TAG, "changeTheme: " + txt_color + " " + bg_color + " " + ct_color);
    }

}