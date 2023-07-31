package com.example.medicine_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.medicine_tracker.Model.Medicine;

public class NotificationActivity extends AppCompatActivity {

    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button yes,no;
        yes=findViewById(R.id.button_yes);
        no=findViewById(R.id.button_no);



        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMedicineInfo();


            }
        });

    }



    private void showMedicineInfo() {
        Cursor cursor=myDatabaseHelper.showAll_Medicine_Data();
        if(cursor.getCount() ==0){
            Toast.makeText(getApplicationContext(),"No data is available in database",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(cursor.moveToNext()){
                i++;

                if(i==1){
                    int doctor_id=cursor.getInt(9);
                    int id=cursor.getInt(0);
                    String name=cursor.getString(1);
                    int morning=cursor.getInt(2);
                    int day=cursor.getInt(3);
                    int night=cursor.getInt(4);
                    int before_meal=cursor.getInt(5);
                    int after_meal=cursor.getInt(6);
                    double quantity=cursor.getDouble(7);
                    int no_of_days=cursor.getInt(8);
                    int medicine_count=cursor.getInt(10);
                    medicine_count=medicine_count-1;
                    if(medicine_count%(morning+day+night)==0){
                        no_of_days=no_of_days-1;
                    }

                    Medicine medicine=new Medicine(doctor_id,id,name,morning,day,
                            night,before_meal,after_meal,quantity,no_of_days,medicine_count);
                    myDatabaseHelper.update_medicine_info(medicine);

                }




            }




        }

    }

}