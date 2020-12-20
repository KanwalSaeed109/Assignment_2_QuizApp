package com.codewitkanwal.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView scoreField;
    Button Restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        scoreField = (TextView) findViewById(R.id.sc_field);
        Restart = (Button) findViewById(R.id.btnRestart);


        StringBuffer sb3 = new StringBuffer();
        sb3.append("Your Score is : " + QuestionActivity.correct + "\n");

        scoreField.setText(sb3);

        QuestionActivity.correct = 0;
        QuestionActivity.wrong = 0;

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });
    }
}