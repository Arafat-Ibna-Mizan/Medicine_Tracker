package com.example.medicine_tracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView doctor_btn,meal_btn,medicine_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        doctor_btn=findViewById(R.id.doctor);
        meal_btn=findViewById(R.id.meal);
        medicine_btn=findViewById(R.id.medicine);
        doctor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openDoctorActivity();
            }
        });
        meal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMealActivity();
            }
        });
        medicine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedicineActivity();
            }
        });


    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        AlertDialog.Builder alertdialog=new AlertDialog.Builder(HomePage.this);
        alertdialog.setTitle("Exit App");
        alertdialog.setMessage("Do you want to exit app?");
        alertdialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alertdialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });alertdialog.show();
    }

    private void openMedicineActivity() {
        Intent medi_intent=new Intent(this,MedicineActivity2.class);
        startActivity(medi_intent);
    }

    private void openMealActivity() {
        Intent meal_intent=new Intent(this,DailyActivity2.class);
        startActivity(meal_intent);
    }

    private void openDoctorActivity() {
        Intent doc_intent=new Intent(this,DoctorActivity2.class);
        startActivity(doc_intent);
    }
}