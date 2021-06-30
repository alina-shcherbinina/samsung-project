package com.example.samsungproject;

import java.util.Arrays;

public class Quiz {
    String[] questions;
    String[] answers;
    String[] correct_answers;

    public Quiz(String[] questions,
            String[] answers,
            String[] correct_answers){
        this.questions = new String[questions.length];
        this.answers = new String[answers.length];
        this.correct_answers = new String[correct_answers.length];
        System.arraycopy(questions, 0, this.questions, 0, questions.length);
        System.arraycopy(answers, 0, this.answers, 0, answers.length);
        System.arraycopy(correct_answers, 0, this.correct_answers, 0, correct_answers.length);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "questions=" + Arrays.toString(questions) +
                ", answers=" + Arrays.toString(answers) +
                ", correct_answers=" + Arrays.toString(correct_answers) +
                '}';
    }
}
