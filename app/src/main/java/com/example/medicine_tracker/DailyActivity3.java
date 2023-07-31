package com.example.medicine_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DailyActivity3 extends AppCompatActivity {
    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily3);
        Button yes,no;
        yes=findViewById(R.id.button_yes);
        no=findViewById(R.id.button_no);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag=myDatabaseHelper.delete_all_meal_data();
                if(flag==0){
                    Toast.makeText(getApplicationContext(), "Sorry! Data is not deleted.\nPlease!try again.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Thank you.\nData are deleted successfully.", Toast.LENGTH_SHORT).show();
                    openpreviousActivity();
                }

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpreviousActivity();
            }
        });
    }

    private void openpreviousActivity() {

            Intent intent1=new Intent(this,DailyActivity2.class);

            startActivity(intent1);

    }

}