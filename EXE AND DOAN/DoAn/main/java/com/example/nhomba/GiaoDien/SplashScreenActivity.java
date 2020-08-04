package com.example.nhomba.GiaoDien;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.R;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);
        final ImageView tien = findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.animation);
        tien.startAnimation(animation);
        ImageView cat = (ImageView) findViewById(R.id.imgCat);
        final AnimationDrawable runningCat = (AnimationDrawable) cat.getDrawable();
        runningCat.start();
        final long SPLASH_TIME_OUT = 3200;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}


