package com.example.medicine_tracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicine_tracker.Model.Doctor;
import com.example.medicine_tracker.Model.Medicine;

import java.util.ArrayList;

public class Medicine_Adapter extends BaseAdapter {
    Context context;
    ArrayList<Medicine> medicine_arrayList;

//    private int taken_medicine,send_value;
//    int value;

    public Medicine_Adapter
            (Context context, ArrayList<Medicine> medicine_arrayList) {
        this.context = context;
        this.medicine_arrayList = medicine_arrayList;
    }

    public Medicine_Adapter() {

    }


    @Override
    public int getCount() {
        return medicine_arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return medicine_arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }







    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView= inflater.inflate(R.layout.medicine_view,null);
        TextView medi_id=convertView.findViewById(R.id.show_id);
        TextView doc_id=convertView.findViewById(R.id.show_doc_id);
        TextView name=convertView.findViewById(R.id.medi_name_field);
        CheckBox morning=convertView.findViewById(R.id.morning_id);


        CheckBox day=convertView.findViewById(R.id.day);

        CheckBox night=convertView.findViewById(R.id.night_show);

        //CheckBox before_meal=convertView.findViewById(R.id.bf_meal);
        // Checkbox after_meal=convertView.findViewById(R.id.af_meal);
        TextView qnty=convertView.findViewById(R.id.qnty_show_field);
        TextView day_cnt=convertView.findViewById(R.id.day_show);
        TextView total_medicine=convertView.findViewById(R.id.total_show);

        Medicine medicine=medicine_arrayList.get(position);
        //work to do from here
        String medicine_id_show=String.valueOf(medicine.getId());
        String doctor_id=String.valueOf(medicine.getDoctor_id());
        String name_name=medicine.getName();
        int m_morning=medicine.getMorning();
        int d_day=medicine.getDay();
        int n_night=medicine.getNight();
        double q_qnty=medicine.getQuantity();
        //need to calculate the remaining day
        int d_day_count=medicine.getNo_of_days();
        int remaining_medicine=medicine.getRem_medicine();

        medi_id.setText(medicine_id_show);
        doc_id.setText(doctor_id);
        name.setText(name_name);
        morning.setChecked(false);
        day.setChecked(false);
        night.setChecked(false);

        if(m_morning==1){
            morning.setChecked(true);

        }
        if(d_day==1){
            day.setChecked(true);
        }
        if(n_night==1){
            night.setChecked(true);
        }
        qnty.setText(String.valueOf(q_qnty));
        day_cnt.setText(String.valueOf(d_day_count));





        total_medicine.setText(String.valueOf(remaining_medicine));




        return convertView;
    }



}
