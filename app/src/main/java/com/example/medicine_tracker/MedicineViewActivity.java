package com.example.medicine_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.medicine_tracker.Model.Doctor;
import com.example.medicine_tracker.Model.Medicine;

import java.util.ArrayList;

public class MedicineViewActivity extends AppCompatActivity {

    ListView listview_medicine;
    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
    Medicine_Adapter medicine_adapter;
   ArrayList<Medicine> medicine_arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_view);

        listview_medicine=findViewById(R.id.listvew_for_medicine);
        showMedicineData();
    }
    private void showMedicineData() {
        medicine_arrayList=getMedicineData();
        medicine_adapter=new Medicine_Adapter(this, medicine_arrayList);
        listview_medicine.setAdapter(medicine_adapter);

    }

    private ArrayList<Medicine> getMedicineData() {
        ArrayList<Medicine> medicine_listData=new ArrayList<>();
        Cursor cursor=myDatabaseHelper.showAll_Medicine_Data();
        if(cursor.getCount() ==0){
            Toast.makeText(getApplicationContext(),"No data is available in database",Toast.LENGTH_LONG).show();
        }else{
            while(cursor.moveToNext()){
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
                int req_medicine=cursor.getInt(10);


                Medicine medicine=new Medicine(doctor_id,id,name,morning,day,
                night,before_meal,after_meal,quantity,no_of_days,req_medicine);
                medicine_listData.add(medicine);
            }
        }
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.doc_list_item,R.id.textViewid,listData);
//        listview.setAdapter(adapter);
        return medicine_listData;

    }
}