package com.bestservicecarlm.bestservicecar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bestservicecarlm.util.util;

public class LoginActivity extends AppCompatActivity {
    private  BestServiceCarAplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        app = (BestServiceCarAplication)getApplication();
    }
    public void doLogin(View view){
        app.registerLogIn();
        util.sendAndFinish(this, MainActivity.class);
    }
}
