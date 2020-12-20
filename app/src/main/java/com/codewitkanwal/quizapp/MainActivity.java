package com.codewitkanwal.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button start = (Button) findViewById(R.id.startBtn);
            final EditText name = (EditText) findViewById(R.id.editName);

            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String n = name.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                    intent.putExtra("myname", n);
                    startActivity(intent);
                }
            });


        }
    }

