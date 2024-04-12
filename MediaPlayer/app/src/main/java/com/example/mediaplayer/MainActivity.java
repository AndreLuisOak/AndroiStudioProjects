package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton cat_btn;

    ImageButton btn_guitar;

    Button btn_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cat_btn = findViewById(R.id.cat_btn);

        cat_btn.setOnClickListener(this);

        btn_guitar = findViewById(R.id.btn_guitar);

        btn_guitar.setOnClickListener(this);

        btn_play = findViewById(R.id.btn_play);

        btn_play.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == cat_btn){
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.chipichipichapa);
            mediaPlayer.start();
        }

        if (v == btn_guitar){
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cantstop);
            mediaPlayer.start();
        }

        if (v == btn_play){
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.driftveilcity);
            mediaPlayer.start();
        }
    }

}