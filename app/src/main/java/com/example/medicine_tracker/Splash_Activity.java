package com.example.medicine_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(5000);

                } catch (Exception ex) {
                    ex.printStackTrace();

                }finally {
                    Intent intent=new Intent(Splash_Activity.this,HomePage.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }

}