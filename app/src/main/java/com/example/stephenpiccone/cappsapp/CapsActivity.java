package com.example.stephenpiccone.cappsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CapsActivity extends AppCompatActivity {
    private Game game;
    private String question;
    private String answer;
    private int score= 0;
    private int qNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);
        ask();

    }

    private void ask()
    {
        this.game = new Game();
        String[] qa = game.qa().split("\\n");

        this.answer = qa[1];
        this.question = qa[0];

        TextView q = (TextView) findViewById(R.id.question);
        q.setText(this.question);
    }
    public void onDone(View v)
    {
        ask();
        qNum++;
        TextView num = (TextView) findViewById(R.id.qNum);
        TextView point = (TextView) findViewById(R.id.score);
        num.setText("Q# "+ qNum);
        String ans = ((EditText) findViewById(R.id.answer)).getText().toString().toUpperCase();
        String log = "Q#" + qNum + ": "+question + "\nYour answer: "+ ans + "\nCorrect answer: " + answer;
        ((TextView) findViewById(R.id.log)).setText(log);
        if(ans == answer.toUpperCase())
        {
            score++;
            point.setText("Score = " + score);

        }
        if(qNum == 10)
        {
            num.setText("Game Over");
            finish();

        }





    }




}
