package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        ImageButton webview_btn;

        webview_btn = findViewById(R.id.webview_btn);

        webview_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);

                startActivity(intent);
            }
        });

        ImageButton btn_recycler;
        btn_recycler = findViewById(R.id.btn_recycler);
        btn_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);

                startActivity(intent);
            }
        });


        ImageButton test_btn;
        test_btn = findViewById(R.id.test_btn);
        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);

                startActivity(intent);
            }
        });

    }
}