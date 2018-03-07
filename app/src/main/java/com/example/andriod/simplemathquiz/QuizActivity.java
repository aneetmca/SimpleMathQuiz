package com.example.andriod.simplemathquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {
TextView tvQuestion;
TextView tvResult;
TextView tvTime;
TextView tvScore;
ImageButton btnRight;
ImageButton btnWrong;
    boolean isResultCorrect;
    int seconds = 59;
    private int score = 0;
    private boolean stopTimer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvScore = (TextView) findViewById(R.id.tvScore);
        btnRight = (ImageButton) findViewById(R.id.btnRight);
        btnWrong = (ImageButton) findViewById(R.id.btnWrong);
        timer();

        btnRight.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                verifyAnswer(true);
            }
        });
        btnWrong.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                verifyAnswer(false);
            }
        });
    }
    private void generateQuestion() {
        isResultCorrect = true;
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        int result = a - b;
        float f = random.nextFloat();
        if (f > 0.5f) {
            result = random.nextInt(100);
            isResultCorrect = false;
        }
        tvQuestion.setText(a + "-" + b);
        tvResult.setText("=" + result);
    }
        public void verifyAnswer(boolean answer) {
            if (answer == isResultCorrect) {
                score += 5;
                tvScore.setText("SCORE: " + score);
            } else {
                Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                score -= 5;
                tvScore.setText("SCORE: " + score);
            }
            generateQuestion();
        }

    private void timer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvTime.setText("TIME :" + seconds);
                seconds--;
                if (seconds < 0) {
                    Intent i = new Intent(QuizActivity.this, ScoreActivity.class);
                    i.putExtra("score", score);
                    startActivity(i);
                    stopTimer = true;
                }
                if (stopTimer == false) {
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause( );
        stopTimer = false;
        finish( );
    }
}
