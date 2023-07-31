package com.example.medicine_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicine_tracker.Model.Doctor;

import java.util.ArrayList;

public class DoctorActivity2 extends AppCompatActivity {
    TextView save_btn,update_btn,view_btn;
    ListView listview;
    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
    Doctor_Adapter adapter;
    ArrayList<Doctor> arrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor2);
        save_btn=findViewById(R.id.save_btn);
        update_btn=findViewById(R.id.update_btn);
        view_btn=findViewById(R.id.view_btn);
        listview=findViewById(R.id.listview);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoctorActivity();
            }
        });

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUpdateDoctorActivity();

            }
        });
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showData();
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openShow_prescription();
            }
        });

//        listview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
    }

    private void openShow_prescription() {
        Intent i=new Intent(this,Show_Prescription.class);
        startActivity(i);
    }

    private void showData() {
        arrayList=getDoctorData();
        adapter=new Doctor_Adapter(this,arrayList);
        listview.setAdapter(adapter);

    }

    private ArrayList<Doctor> getDoctorData() {
        ArrayList<Doctor> listData=new ArrayList<>();
        Cursor cursor=myDatabaseHelper.showAllData();
        if(cursor.getCount() ==0){
            Toast.makeText(getApplicationContext(),"No data is available in database",Toast.LENGTH_LONG).show();
        }else{
            while(cursor.moveToNext()){
                String name=cursor.getString(1);
                int id=cursor.getInt(0);

                String first_date=cursor.getString(2);
                String next_date=cursor.getString(3);
                byte[] image=cursor.getBlob(4);
                Doctor doctor=new Doctor(name,id,first_date,next_date,image);
                listData.add(doctor);
            }
        }
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.doc_list_item,R.id.textViewid,listData);
//        listview.setAdapter(adapter);
        return listData;

    }

    private void openUpdateDoctorActivity() {
        Intent doc_intent2=new Intent(this,DoctorActivity3.class);
        startActivity(doc_intent2);
    }

    private void openDoctorActivity() {
        Intent doc_intent=new Intent(this,DoctorActivity.class);
        startActivity(doc_intent);
    }
}