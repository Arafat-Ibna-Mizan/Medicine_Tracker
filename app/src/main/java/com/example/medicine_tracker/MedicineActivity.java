package com.example.medicine_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicine_tracker.Model.Medicine;

public class MedicineActivity extends AppCompatActivity {
    EditText medicine_id,medi_doc,medicine_name,no_of_quantity,no_days;
    TextView back_button,save_button;
    CheckBox cheque_morning,cheque_day,cheque_night,cheque_before,cheque_after;

    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
    Medicine medicine=new Medicine();

    int d_id,m_id,morning_time=0,day_time=0,night_time=0,before_meal=0,after_meal=0,no_of_days,doc_id;
    String name;
    double quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);


        medi_doc=findViewById(R.id.medi_doc_id_field);
        medicine_id=findViewById(R.id.medicine_id_field);
        medicine_name=findViewById(R.id.medicine_name1);
        no_of_quantity=findViewById(R.id.medi1_qnty_field);
        no_days=findViewById(R.id.medi1_no_of_days_field);
        back_button=findViewById(R.id.medi_back);
        save_button=findViewById(R.id.save);
        cheque_morning=findViewById(R.id.med1_morning_checkbox);
        cheque_day=findViewById(R.id.medi1_day);
        cheque_night=findViewById(R.id.medi1_night);
        cheque_before=findViewById(R.id.medi1_beforemeal);
        cheque_after=findViewById(R.id.medi1_aftermeal);





        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cheque_morning.isChecked()){
                    morning_time=1;
                }
                if(cheque_day.isChecked()){
                    day_time=1;
                }
                if(cheque_night.isChecked()){
                    night_time=1;
                }
                if( cheque_before.isChecked()){
                    before_meal=1;
                }
                if(cheque_after.isChecked()){
                    after_meal=1;
                }
                SaveDataToDatabase();

            }
        });

    }

    private void SaveDataToDatabase() {

        d_id=Integer.parseInt(medi_doc.getText().toString());
        m_id=Integer.parseInt(medicine_id.getText().toString());
        name=medicine_name.getText().toString();
        no_of_days=Integer.parseInt(no_days.getText().toString());
        quantity=Double.parseDouble(no_of_quantity.getText().toString());

        medicine.setDoctor_id(d_id);
        medicine.setId(m_id);
        medicine.setName(name);
        medicine.setMorning(morning_time);
        medicine.setDay(day_time);
        medicine.setNight(night_time);
        medicine.setBefore_meal(before_meal);
        medicine.setAfter_meal(after_meal);
        medicine.setQuantity(quantity);
        medicine.setNo_of_days(no_of_days);
        int remain_medicine= (int) (no_of_days*quantity*(morning_time+day_time+night_time));
        medicine.setRem_medicine(remain_medicine);

        long r_id=myDatabaseHelper.insert_medicine_informatation(medicine);
        if(r_id==-1){
            Toast.makeText(getApplicationContext(),"Unsuccessful insertion",Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(getApplicationContext(),"Row"+r_id+"Row is successfully inserted",Toast.LENGTH_LONG).show();
        }

    }
}