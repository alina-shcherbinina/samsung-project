package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tv_result, tv_desc;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_result);

        tv_desc = findViewById(R.id.tv_desc);
        tv_result = findViewById(R.id.tv_result);

        String score = getIntent().getStringExtra("scoreINTENT");
        String len = getIntent().getStringExtra("lenINTENT");

        tv_result.setText(getString(R.string.your_result) + " " + score + " " + getString(R.string.out) + " " + len);

        if (Integer.parseInt(score) <= 1) {
            tv_desc.setText(R.string.again);
        } else if (score.equals(len)) {
            tv_desc.setText(R.string.goodjob);
        } else {
            tv_desc.setText(R.string.fine);
        }

        Button btn_menu;
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btn_again;
        btn_again = findViewById(R.id.btn_again);
        btn_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}