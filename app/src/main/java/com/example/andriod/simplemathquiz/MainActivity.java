package com.example.andriod.simplemathquiz;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btnShare, btnPlay, btnRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShare = (ImageButton) findViewById(R.id.btnShare);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnRate = (ImageButton) findViewById(R.id.btnRate);

        btnShare.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Learn with Fun.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
btnPlay.setOnClickListener(new View.OnClickListener( ) {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
    }
});
btnRate.setOnClickListener(new View.OnClickListener( ) {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,"You can open your Google Play landing page", Toast.LENGTH_LONG ).show();
    }
});
    }
}


