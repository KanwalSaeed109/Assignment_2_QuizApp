package com.codewitkanwal.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    TextView tv;
    Button submit, quit;
    RadioGroup radio_group;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "1) Who is the Patron Saint of Spain?",
            "2) Which of these means a speech in a play where a character talks to themselves rather than to other characters?",
            "3) In the Vicar of Dibley, what was the name of the vicar's clueless friend?",
            "4) Casterly Rock is the ancestral home of which family in Game of Thrones?",
            "5) Which breed of dog used to be sacred in China?",
            "6) Which philosopher coined the term 'I think, therefore I am'?",
            "7) Who was mayor of London before Boris Johnson?",
            "8) Which two countries are Europes biggest exporters of beers?",
            "9) Which two calendar months are named after Roman Emperors?",
            "10) How many novels did the Bronte sisters write in total?"
    };
    String answers[] = {"b) St John",
            "c) Soliloquy",
            "a) Alice",
            "b) The Tully's",
            "d) All",
            "b) Descartes",
            "d) None of them",
            "a) Germany and Belgium",
            "b) December and May",
            "b) Seven"};
    String opt[] = {
            "a) St James","b) St John","c) St Benedict","d) None",
            "a) Interlude","b) Revue","c) Soliloquy","d) None",
            "a) Alice","b) Beatrice","c) Charlotte","d) None",
            "a) The Starks","b) The Tully's","c) The Lannisters","d) None",
            "a) Cockapoo","b) Pekingese","c) Spaniel","d) All",
            "a) Plato","b) Descartes","c) Socrates","d) None of them",
            "a) Sadiq Khan","b) John Major","c) Ken Livingston","d) None of them",
            "a) Germany and Belgium","b) Germany and Spain","c) Belgium and Spain","d) Europe and Spain",
            "a) July and June","b) December and May","c) July and August","d) January and March",
            "a) Nine","b) Seven","c) Eight","d) Six"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final TextView score = (TextView)findViewById(R.id.textView4);


        submit=(Button)findViewById(R.id.button3);
        quit=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_group=(RadioGroup)findViewById(R.id.answersGrp);
        rb1=(RadioButton)findViewById(R.id.rd);
        rb2=(RadioButton)findViewById(R.id.rd2);
        rb3=(RadioButton)findViewById(R.id.rd3);
        rb4=(RadioButton)findViewById(R.id.rd4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(radio_group.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_group.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ScoreActivity.class);
                    startActivity(in);
                }
                radio_group.clearCheck();
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ScoreActivity.class);
                startActivity(intent);
            }
        });
    }

}