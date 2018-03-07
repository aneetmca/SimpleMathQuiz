package com.example.andriod.simplemathquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
ImageButton btShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView tv = (TextView) findViewById(R.id.score);
        int score = getIntent().getIntExtra("score", 0);
        tv.setText("Current Score : " + score);
        ImageButton btshare = (ImageButton) findViewById(R.id.btShare);
        btshare.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }
}
