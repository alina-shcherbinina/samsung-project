package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

import static android.content.ContentValues.TAG;

public class QuizActivity extends AppCompatActivity  implements View.OnClickListener {
    Resources res;
    int step;
    Quiz quiz_1;
    int score;
    TypedArray ta;
    TextView tv_question, tv_score;
    String[] questions; String answers; String[] separated; String correct_answer;
    Button tv_answer_1, tv_answer_2, tv_answer_3, tv_answer_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_quiz_activiy);
        step = 0;
        score = 0;
        tv_question = findViewById(R.id.tv_question);

        tv_score = findViewById(R.id.tv_score);

        tv_answer_1 = findViewById(R.id.tv_answer_1);
        tv_answer_2 = findViewById(R.id.tv_answer_2);
        tv_answer_3 = findViewById(R.id.tv_answer_3);
        tv_answer_4 = findViewById(R.id.tv_answer_4);
        tv_answer_1.setOnClickListener(this);
        tv_answer_2.setOnClickListener(this);
        tv_answer_3.setOnClickListener(this);
        tv_answer_4.setOnClickListener(this);

        res = getResources();
        ta = res.obtainTypedArray(R.array.quiz_1);

        quiz_1 = new Quiz(getArray(2), getArray(3), getArray(4));
        Log.d(TAG, "onCreate: "+ quiz_1.toString());
        NextQuestion(step);
        tv_score.setText(score + " of " + quiz_1.questions.length);

        ta.recycle(); // Important!
    }

    private void NextQuestion(int step) {
        questions = quiz_1.questions;
        tv_question.setText(questions[step]);

        answers = quiz_1.answers[step];
        separated = answers.split(";");
        tv_answer_1.setText(separated[0]);
        tv_answer_2.setText(separated[1]);
        tv_answer_3.setText(separated[2]);
        tv_answer_4.setText(separated[3]);
        Log.d(TAG, "NextQuestion: " + score);
        tv_score.setText(score + " of " + quiz_1.questions.length);

        correct_answer = quiz_1.correct_answers[step];
    }


    String[] getArray(int i) {

        int id = ta.getResourceId(i, 0);
        if (id > 0) {
            return res.getStringArray(id);
        } else {
            // something wrong with the XML
        }
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_answer_1:
                score = checkAnswer(tv_answer_1);
                break;
            case R.id.tv_answer_2:
                score = checkAnswer(tv_answer_2);
                break;
            case R.id.tv_answer_3:
                score = checkAnswer(tv_answer_3);
                break;
            case R.id.tv_answer_4:
                score = checkAnswer(tv_answer_4);
                break;
        }

        step++;

        if (step > quiz_1.questions.length - 1) {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("scoreINTENT", String.valueOf(score));
            intent.putExtra("lenINTENT", String.valueOf(quiz_1.questions.length));
            startActivity(intent);
        } else {
            NextQuestion(step);
        }

    }

    public int checkAnswer(Button button){

        if (button.getText().toString().equals(correct_answer))
        {
            score++;
        }

        return score;
    }
}