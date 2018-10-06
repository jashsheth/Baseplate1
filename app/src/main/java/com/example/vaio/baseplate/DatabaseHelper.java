package com.example.vaio.baseplate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="complain.db";
    public static final String TABLE_NAME="C_TABLE";
    public static final String ID="ID";
    public static final String NAME="NAME";
    public static final String COMPLAIN="COMPLAIN";
    public static final String LOCATION="LOCATION";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)")
           db.execSQL("create table "+ TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT , COMPLAIN TEXT ,LOCATION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
    onCreate(db);
    }
    public boolean insertData(String name,String Complain,String location)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,name);
        cv.put(COMPLAIN,Complain);
        cv.put(LOCATION,location);
        Long result= db.insert(TABLE_NAME,null,cv);
        if(result== -1) {

            return false;
        }
            else {
            return true;
        }


    }
    public Cursor getData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
