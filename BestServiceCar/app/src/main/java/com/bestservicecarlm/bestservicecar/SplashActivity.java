package com.bestservicecarlm.bestservicecar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bestservicecarlm.util.util;

public class SplashActivity extends AppCompatActivity {
    private BestServiceCarAplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        app = (BestServiceCarAplication)getApplicationContext();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(app.isLoginStart()){
                    util.sendAndFinish(SplashActivity.this, MainActivity.class);
                }else{
                    util.sendAndFinish(SplashActivity.this, LoginActivity.class);
                }
            }
        }, 5000);
    }
}
