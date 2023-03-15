package com.example.logindatainsert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    MySharedPreference sharedPreference;
    int SPLASH_DISPLAY_LENGTH=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreference= MySharedPreference.getPreferences(this);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                if (sharedPreference.getLogin().equals("logged")) {

                    Intent mainIntent = new Intent(SplashActivity.this,ProfileActivity.class);
                    startActivity(mainIntent);
                    finish();

                }else {

                    Intent mainIntent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(mainIntent);
                    finish();

                }

            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}