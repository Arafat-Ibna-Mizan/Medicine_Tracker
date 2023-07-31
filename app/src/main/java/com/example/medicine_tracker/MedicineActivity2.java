package com.example.medicine_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MedicineActivity2 extends AppCompatActivity {
    TextView save_btn,update_btn,view_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine2);

        save_btn=findViewById(R.id.insert);
        update_btn=findViewById(R.id.update);
        view_btn=findViewById(R.id.viewdata);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSaveMedicine();
            }
        });

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openupdateMedicine();
            }
        });
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShowmedicinedata();
            }
        });
    }

    private void openupdateMedicine() {

        Intent updt_intent=new Intent(this,MedicineActivity3.class);
        startActivity(updt_intent);
    }

    private void openSaveMedicine() {
        Intent medi_intent=new Intent(this,MedicineActivity.class);
        startActivity(medi_intent);
    }
    private void openShowmedicinedata() {
        Intent view_intent=new Intent(this,MedicineViewActivity.class);
        startActivity(view_intent);
    }
}