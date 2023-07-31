package com.example.medicine_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicine_tracker.Model.Doctor;
import com.example.medicine_tracker.Model.Meal_time;

import java.sql.Time;
import java.util.ArrayList;

public class DailyActivity2 extends AppCompatActivity {
    TextView save_btn,update_btn,view_btn,morning_view,day_view,night_view;
    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily2);

        save_btn=findViewById(R.id.insert);
        update_btn=findViewById(R.id.update);
        view_btn=findViewById(R.id.viewdata);
        morning_view=findViewById(R.id.morning_time);
        day_view=findViewById(R.id.day_time);
        night_view=findViewById(R.id.night_time);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSavedailyactivity();
            }
        });

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openupdatedailyactivity();
            }
        });

        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDailyData();
            }
        });
    }

    private void showDailyData() {
        Cursor cursor=myDatabaseHelper.show_daily_data();
        if(cursor.getCount() ==0){
            Toast.makeText(getApplicationContext(),"No data is available in database",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(cursor.moveToNext()){
                i++;

                if(i==1){
                    String meal_id=cursor.getString(0);
                    String meal_time=cursor.getString(1);
                    morning_view.setText(meal_time);
                    //++i;

                }
                if(i==2){
                    String meal_id=cursor.getString(0);
                    String meal_time=cursor.getString(1);
                    day_view.setText(meal_time);
                    //++i;
                }
                if(i==3){
                    String meal_id=cursor.getString(0);
                    String meal_time=cursor.getString(1);
                    night_view.setText(meal_time);

                }


            }
        }


    }


    private void openupdatedailyactivity() {
        Intent dailyactivity2=new Intent(this,DailyActivity3.class);
        startActivity(dailyactivity2);
    }

    private void openSavedailyactivity() {
        Intent dailyactivity=new Intent(this,DailyActivity.class);
        startActivity(dailyactivity);
    }
}