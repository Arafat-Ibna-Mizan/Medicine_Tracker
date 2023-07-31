package com.example.medicine_tracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.medicine_tracker.Model.Meal_time;

import java.sql.SQLOutput;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class DailyActivity extends AppCompatActivity {
    EditText morning_time,day_time,night_time;
    Button morning_btn,lunch_btn,dinner_btn;
    int m_hour,m_minute,m_second;

    public AlarmManager alarmManager;
    public AlarmManager alarmManager2;
    public AlarmManager alarmManager3;
    public PendingIntent pendingIntent;
    public PendingIntent pendingIntent2;
    public PendingIntent pendingIntent3;
    public Calendar calendar;
    Meal_time meal_time=new Meal_time();
    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);




    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        morning_time=findViewById(R.id.morning_time_field);
        day_time=findViewById(R.id.lunch_time_field);
        night_time=findViewById(R.id.dinner_time_field);
        morning_btn=findViewById(R.id.morning_button);
        lunch_btn=findViewById(R.id.lunch_button);
        dinner_btn=findViewById(R.id.dinner_button);


        //createNotificationChannel();

        morning_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setTime(morning_time);


            }
        });
        day_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              setTime(day_time);

            }
        });
        night_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setTime(night_time);


            }
        });

        morning_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotificationChannel();
                setAlarm_morning();
            }
        });
        lunch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotificationChannel();
                setAlarm_day();
            }
        });
        dinner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotificationChannel();
                setAlarm_night();
            }
        });

        TextView nxt_pg;
        nxt_pg=findViewById(R.id.NextView);
        nxt_pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                saveDataToDatabase();
                    //setAlarm();
                   // openMedicineActivity();



            }


        });



    }

    public void setAlarm_morning() {
        alarmManager=(AlarmManager)  getSystemService(Context.ALARM_SERVICE);


        Intent intent=new Intent(this,AlarmReceiver.class);



        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_MUTABLE);
        long alarm_time=calendar.getTimeInMillis();
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, alarm_time,
                AlarmManager.INTERVAL_DAY,pendingIntent);
        Toast.makeText(this,"Alarm set Successfully",Toast.LENGTH_SHORT).show();
        System.out.println("Set Alarm is executing");
        System.out.println("the time is:"+alarm_time);



   }
    public void setAlarm_day() {
        alarmManager2=(AlarmManager)  getSystemService(Context.ALARM_SERVICE);


        Intent intent2=new Intent(this,AlarmReceiver_day.class);



        pendingIntent2 = PendingIntent.getBroadcast(this, 2, intent2, PendingIntent.FLAG_MUTABLE);
        long alarm_time=calendar.getTimeInMillis();
        alarmManager2.setInexactRepeating(AlarmManager.RTC_WAKEUP, alarm_time,
                AlarmManager.INTERVAL_DAY,pendingIntent2);
        Toast.makeText(this,"Alarm2 set Successfully",Toast.LENGTH_SHORT).show();
        System.out.println("Set Alarm2 is executing");
        System.out.println("the time 2 is:"+alarm_time);



    }
    public void setAlarm_night() {
        alarmManager3=(AlarmManager)  getSystemService(Context.ALARM_SERVICE);


        Intent intent3=new Intent(this,AlarmReceiver_night.class);



        pendingIntent3 = PendingIntent.getBroadcast(this, 3, intent3, PendingIntent.FLAG_MUTABLE);
        long alarm_time=calendar.getTimeInMillis();
        alarmManager3.setInexactRepeating(AlarmManager.RTC_WAKEUP, alarm_time,
                AlarmManager.INTERVAL_DAY,pendingIntent3);
        Toast.makeText(this,"Alarm 3 set Successfully",Toast.LENGTH_SHORT).show();
        System.out.println("Set Alarm is executing");
        System.out.println("the time 3 is:"+alarm_time);



    }



        @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
           // int flagUpdateCurrent = PendingIntent.FLAG_MUTABLE;

            CharSequence name = "Medicine Tracker";
            String description = "Channel for Alarm Manager";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("Medicine Tracker", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            System.out.println("Notification is created\n");
        }
    }






    public void setTime(EditText timeview) {



//        TimePickerDialog timePickerDialog=new TimePickerDialog(
//                DailyActivity.this,
//                new TimePickerDialog.OnTimeSetListener() {
//
//                    @Override
//                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
//                        m_hour=i;
//                        m_minute=i1;
//
//                        //Initializing calender
//                        calendar=Calendar.getInstance();
//                        calendar.set(0,0,0,m_hour,m_minute);
//                        timeview.setText(DateFormat.format("hh:mm aa", calendar));
//
//
//
//
//
//                    }
//                }, 12, 0, false
//        );
//        timePickerDialog.updateTime(m_hour,m_minute);
//        timePickerDialog.show();
        TimePickerDialog timePickerDialog=new TimePickerDialog(DailyActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar=Calendar.getInstance();


                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                calendar.set(Calendar.SECOND,0);
                timeview.setText(DateFormat.format("hh:mm aa", calendar));
                m_hour=calendar.get(Calendar.HOUR_OF_DAY);
                m_minute=calendar.get(Calendar.MINUTE);
            }
        }, 12, 0, false);
        timePickerDialog.updateTime(m_hour,m_minute);
        timePickerDialog.show();



    }

    private void saveDataToDatabase() {
        String morning=morning_time.getText().toString();
        String day=day_time.getText().toString();
        String night=night_time.getText().toString();
        meal_time.setMeal_id("");
        meal_time.setMorning(morning);
        meal_time.setDay(day);
        meal_time.setNight(night);
        long row_id=myDatabaseHelper.insert_meal_time(meal_time);
        if(row_id==-1){
            Toast.makeText(getApplicationContext(),"Unsuccessful insertion",Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(getApplicationContext(),"Row"+row_id+"Row is successfully inserted",Toast.LENGTH_LONG).show();
        }



    }



}

