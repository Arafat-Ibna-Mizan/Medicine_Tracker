package com.example.medicine_tracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medicine_tracker.Model.Doctor;

import java.util.ArrayList;

public class Doctor_Adapter extends BaseAdapter {
    Context context;
    ArrayList<Doctor>arrayList;
    Bitmap bitmap;

    public Doctor_Adapter(Context context, ArrayList<Doctor> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public Doctor_Adapter(Show_Prescription context) {
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView= inflater.inflate(R.layout.doc_list_item,null);
        ImageView image=convertView.findViewById(R.id.imageView);
        TextView doc_id=convertView.findViewById(R.id.docview_id);
        TextView name=convertView.findViewById(R.id.name_id);
        TextView first_date=convertView.findViewById(R.id.date_id);
        TextView next_date=convertView.findViewById(R.id.date_id2);
        Doctor doctor=arrayList.get(position);
        int d_id=doctor.getId();
        String dd_id=String.valueOf(d_id);
        String d_name=doctor.getDoc_name();
        String p_date=doctor.getFirst_date();
        String n_date=doctor.getMeet_date();
        byte[] pic=doctor.getPicture();
        bitmap= BitmapFactory.decodeByteArray(pic,0,pic.length);

        doc_id.setText(dd_id);
        name.setText(d_name);
        first_date.setText(p_date);
        next_date.setText(n_date);
        image.setImageBitmap(bitmap);


        return convertView;
    }
   public Bitmap send_bitmap(){
        return bitmap;
   }
}
