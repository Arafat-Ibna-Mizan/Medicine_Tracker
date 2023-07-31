package com.example.medicine_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.medicine_tracker.Model.Doctor;

public class Show_Prescription extends AppCompatActivity {
    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
    Doctor_Adapter doctor_adapter=new Doctor_Adapter(this);
    Doctor doctor=new Doctor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_prescription);
        ImageView img_view;
        Button back;
        back=findViewById(R.id.button_back);
        img_view=findViewById(R.id.pres_image);
        //Bitmap bp=doctor_adapter.send_bitmap();
//        byte[] image = doctor.getPicture();
//        System.out.println(image);
//        Bitmap bp = BitmapFactory.decodeByteArray(image, 0, image.length);
//        if(bp==null){
//            System.out.println("Image did not find");
//
//        }
//        else{
//            img_view.setImageBitmap(bp);
//        }



        Cursor cursor=myDatabaseHelper.showAllData();
        if(cursor.getCount() ==0){
            Toast.makeText(getApplicationContext(),"No data is available in database",Toast.LENGTH_LONG).show();
        }else{
            Bitmap bitmap;


            if(cursor.moveToNext()){



                    byte[] image = cursor.getBlob(4);
                    System.out.println("image is:"+image);

                   bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
                    img_view.setImageBitmap(bitmap);


                }


            }




    }
}