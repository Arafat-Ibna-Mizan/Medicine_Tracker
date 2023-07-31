package com.example.medicine_tracker;

import android.app.DatePickerDialog;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.medicine_tracker.Model.Doctor;
import com.github.dhaval2404.imagepicker.ImagePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Date;

public class DoctorActivity extends AppCompatActivity {
    EditText date_format;
    EditText next_meet_date;
    EditText doc_name_text_field;
    EditText doc_id;
    int year,month,day;
    ImageView image_view;
    FloatingActionButton fab;
    TextView next_button;
    //Taking database reference

    Uri uri;
    String image_location;
    //Making object for model class
   Doctor doctor=new Doctor();



// creating objects of my database.
    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase sqLiteDatabase=myDatabaseHelper.getWritableDatabase();

        image_view=findViewById(R.id.pres_image);
        fab=findViewById(R.id.img_button);

        date_format=findViewById(R.id.id_date);
        next_meet_date=findViewById(R.id.id_next_date);
        doc_name_text_field=findViewById(R.id.doc_name_field);
        doc_id=findViewById(R.id.doc_id);
        Calendar calendar=Calendar.getInstance();


        //Sqlite database object





        date_format.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
               DatePickerDialog datePickerDialog=new DatePickerDialog(
                       DoctorActivity.this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker view, int year, int month, int day) {
                       month+=1;
                       String date=day+"/"+month+"/"+year;
                       date_format.setText(date);

                   }
               },year,month,day
               );
                datePickerDialog.show();

            }
        });

        next_meet_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        DoctorActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month+=1;
                        String date=day+"/"+month+"/"+year;
                        next_meet_date.setText(date);

                    }
                },year,month,day
                );
                datePickerDialog.show();

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(DoctorActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });


       next_button=findViewById(R.id.Next_button);
       next_button.setOnClickListener(view -> {
           saveDataToDatabase();



       });






    }

    private void saveDataToDatabase() {
        String d_name=doc_name_text_field.getText().toString();
        String dd_id=doc_id.getText().toString();
        String f_meet=date_format.getText().toString();
        String n_meet=next_meet_date.getText().toString();
        Bitmap bitmap= BitmapFactory.decodeFile(uri.getPath());
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
        byte[] img=byteArrayOutputStream.toByteArray();
        doctor.setDoc_name(d_name);
        int d_id=Integer.parseInt(dd_id);
        doctor.setId(d_id);
        doctor.setFirst_date(f_meet);
        doctor.setMeet_date(n_meet);
        doctor.setPicture(img);

        if(doc_name_text_field.getText().toString()!=" " & doc_id.getText().toString()!=" " & date_format.getText().toString()!=" " & n_meet!=" "){
             long row_id=myDatabaseHelper.insert_doc_data(doctor);
            if(row_id==-1){
                Toast.makeText(getApplicationContext(),"Unsuccessful insertion",Toast.LENGTH_LONG).show();


            }
            else {
                Toast.makeText(getApplicationContext(),"Row"+row_id+"Row is successfully inserted",Toast.LENGTH_LONG).show();
                openDoctorActivity2();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Please,Fill up all the data",Toast.LENGTH_LONG).show();
        }






    }


    public void openDoctorActivity2(){
        Intent intent=new Intent(this,DoctorActivity2.class);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        uri=data.getData();
        image_view.setImageURI(uri);
    }

//    public String getFileExtension(Uri uri){
//        Uri uri1=uri;
//        ContentResolver contentResolver=getContentResolver();
//        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
//        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri1));
//    }


}