package com.example.zhangfan.udaquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private CheckBox mQuizOneOne;
    private CheckBox mQuizOneTwo;
    private CheckBox mQuizOneThree;

    private RadioButton mQuizTwoOne;

    private EditText mQuizThree;

    private CheckBox mQuizFourOne;
    private CheckBox mQuizFourTwo;
    private CheckBox mQuizFourThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuizOneOne = (CheckBox) findViewById(R.id.quiz_one_answer_one);
        mQuizOneTwo = (CheckBox) findViewById(R.id.quiz_one_answer_two);
        mQuizOneThree = (CheckBox) findViewById(R.id.quiz_one_answer_three);

        mQuizTwoOne = (RadioButton) findViewById(R.id.quiz_two_answer_one);

        mQuizThree = (EditText) findViewById(R.id.quiz_three_answer);

        mQuizFourOne = (CheckBox) findViewById(R.id.quiz_four_answer_one);
        mQuizFourTwo = (CheckBox) findViewById(R.id.quiz_four_answer_two);
        mQuizFourThree = (CheckBox) findViewById(R.id.quiz_four_answer_three);
    }

    private int calculateQuizOne() {
        int result = 0;
        if (mQuizOneOne.isChecked() && mQuizOneTwo.isChecked() && mQuizOneThree.isChecked()) {
            result = 25;
        }
        return result;
    }

    private int calculateQuizTwo() {
        int result = 0;
        if (mQuizTwoOne.isChecked()) {
            result = 25;
        }
        return result;
    }

    private int calculateQuizThree() {
        int result = 0;
        String key = getString(R.string.quiz_three_answer);
        if (mQuizThree.getText().toString().trim().equals(key)) {
            result = 25;
        }
        return result;
    }

    private int calculateQuizFour() {
        int result = 0;
        if (mQuizFourOne.isChecked() && mQuizFourTwo.isChecked() && !mQuizFourThree.isChecked()) {
            result = 25;
        }
        return result;
    }

    public void submitQuiz(View view) {
        int totalScore = calculateQuizOne() + calculateQuizTwo() + calculateQuizThree() + calculateQuizFour();
        String message = "";
        if (totalScore == 100) {
            message = "Great! You got 100 score!";
        } else {
            message = "Come on! You got " + totalScore + " score!";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
