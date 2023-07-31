package com.example.medicine_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.medicine_tracker.Model.Doctor;
import com.example.medicine_tracker.Model.Meal_time;
import com.example.medicine_tracker.Model.Medicine;


public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static  final  String DATABASE_NAME="Medicine_Tracker.db";

    private static final String doc_table="Doctor_Table";
    private static final String doc_id="Doc_Id";
    private static final String doc_name="Doc_Name";
    private static final String doc_first_meet_date="First_Meet";
    private static final String doc_next_meet_date="Next_Date";
    private static final String doc_img="Image";

    //For meal Table
    private static final String meal_table="Meal_Table";
    private static final String meal_id="Meal_Id";
    private static final String meal_time="Meal_Time";
    //
    //for Medicine
    private static final String medi_table="Medicine_Table";
    private static final String medi_id="Medi_Id";
    private static final String medi_name="Medi_Name";
    private static final String morning_time="Morning";
    private static final String day_time="Day";
    private static final String night_time="Night";
    private static final String before_meal="Before_Meal";
    private static final String after_meal="After_Meal";
    private static final String medi_qnty="Quantity";
    private static final String no_of_days="No_of_Days";
    private static final String medi_doc_id="Doc_id";
    private static final String remain_medicine="rem_medi";

    //doc_table query
    private  static final String CREATE_DOC_TABLE="CREATE TABLE "+doc_table+"("+ doc_id+" INTEGER PRIMARY KEY,"+ doc_name+" VARCHAR(255),"+ doc_first_meet_date+" DATE,"+ doc_next_meet_date+" DATE,"+ doc_img+" VARBINARY)";

    //Meal_table query
    private  static final String CREATE_MEAL_TABLE="CREATE TABLE "+meal_table+"("+meal_id+" VARCHAR(255),"+meal_time+" VARCHAR(255))";

    // Medicine table query
    private  static final String CREATE_MED_TABLE="CREATE TABLE "+medi_table+"("+medi_id+" INTEGER PRIMARY KEY,"+ medi_name+" VARCHAR(255),"+ morning_time+" INTEGER,"+ day_time+" INTEGER,"+ night_time+" INTEGER,"+ before_meal+" INTEGER,"+ after_meal+" INTEGER,"+ medi_qnty+" DOUBLE,"+ no_of_days+" INTEGER,"+ medi_doc_id+" INTEGER,"+remain_medicine+" INTEGER,"+ " FOREIGN KEY ("+medi_doc_id+") REFERENCES "+doc_table+"("+doc_id+"))";



    private static  final int VERSION_NUMBER=1;
    private final Context context;
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            Toast.makeText(context,"on Create is called",Toast.LENGTH_LONG).show();

            db.execSQL(CREATE_DOC_TABLE);
            db.execSQL(CREATE_MEAL_TABLE);
            db.execSQL(CREATE_MED_TABLE);
        }catch (Exception e){
            Toast.makeText(context, "Exception:"+e, Toast.LENGTH_SHORT).show();
            System.out.println("Exception is :"+e);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert_doc_data(Doctor doctor){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(doc_id,doctor.getId());
        contentValues.put(doc_name,doctor.getDoc_name());
        contentValues.put(doc_first_meet_date,doctor.getFirst_date());
        contentValues.put(doc_next_meet_date,doctor.getMeet_date());
        contentValues.put(doc_img,doctor.getPicture());
        return sqLiteDatabase.insert(doc_table, null, contentValues);

    }

    public long update_doc_data(Doctor doctor){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(doc_id,doctor.getId());
        contentValues.put(doc_name,doctor.getDoc_name());
        contentValues.put(doc_first_meet_date,doctor.getFirst_date());
        contentValues.put(doc_next_meet_date,doctor.getMeet_date());
        contentValues.put(doc_img,doctor.getPicture());
        String id=String.valueOf(doctor.getId());
        return sqLiteDatabase.update(doc_table,contentValues,"doc_id=?",new String[] {String.valueOf(doctor.getId())});

    }



    public long insert_meal_time(Meal_time meal_time1){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(meal_id,"Morning");
        contentValues.put(meal_time,meal_time1.getMorning());
        sqLiteDatabase.insert(meal_table, null, contentValues);

        contentValues.put(meal_id,"Day");
        contentValues.put(meal_time,meal_time1.getDay());
        sqLiteDatabase.insert(meal_table, null, contentValues);

        contentValues.put(meal_id,"Night");
        contentValues.put(meal_time,meal_time1.getNight());
        return (sqLiteDatabase.insert(meal_table, null, contentValues));

    }

    public long insert_medicine_informatation(Medicine medicine){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(medi_id,medicine.getId());
        contentValues.put(medi_name,medicine.getName());
        contentValues.put(morning_time,medicine.getMorning());
        contentValues.put(day_time,medicine.getDay());
        contentValues.put(night_time,medicine.getNight());
        contentValues.put(before_meal,medicine.getBefore_meal());
        contentValues.put(after_meal,medicine.getAfter_meal());
        contentValues.put(medi_qnty,medicine.getQuantity());
        contentValues.put(no_of_days,medicine.getNo_of_days());
        contentValues.put(medi_doc_id,medicine.getDoctor_id());
        contentValues.put(remain_medicine,medicine.getRem_medicine());
        return (sqLiteDatabase.insert(medi_table, null, contentValues));
    }
    public void update_medicine_info(Medicine medicine){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(medi_id,medicine.getId());
        contentValues.put(medi_name,medicine.getName());
        contentValues.put(morning_time,medicine.getMorning());
        contentValues.put(day_time,medicine.getDay());
        contentValues.put(night_time,medicine.getNight());
        contentValues.put(before_meal,medicine.getBefore_meal());
        contentValues.put(after_meal,medicine.getAfter_meal());
        contentValues.put(medi_qnty,medicine.getQuantity());
        contentValues.put(no_of_days,medicine.getNo_of_days());
        contentValues.put(medi_doc_id,medicine.getDoctor_id());
        contentValues.put(remain_medicine,medicine.getRem_medicine());
        sqLiteDatabase.update(medi_table,contentValues,"medi_id=?",new String[] {String.valueOf(medicine.getId())});
    }
    public Cursor showAllData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+doc_table,null);
        return cursor;
    }

    public Cursor showAll_Medicine_Data(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor medicine_cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+medi_table,null);
        return medicine_cursor;
    }
    public Cursor show_daily_data(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

       Cursor meal_cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+meal_table,null);
       return meal_cursor;

    }
    public int delete_all_meal_data(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        return sqLiteDatabase.delete(meal_table,null,null);
    }
}
