package com.example.nhomba.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhomba.Model.PhongBanClass;

import java.util.ArrayList;


public class DBPhongBan {
    DBHelperPhongBan dbHelperPhongBan;

    public DBPhongBan(Context context) {
        dbHelperPhongBan= new DBHelperPhongBan(context);
    }

    public void Them(PhongBanClass phongBanClass)
    {
        SQLiteDatabase db = dbHelperPhongBan.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mapb",phongBanClass.getMaPB());
        values.put("tenphongban",phongBanClass.getTenPhongBan());
        db.insert("PhongBan",null,values);
    }

    public  void Sua(PhongBanClass phongBanClass)
    {

        SQLiteDatabase db = dbHelperPhongBan.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mapb",phongBanClass.getMaPB());
        values.put("tenphongban",phongBanClass.getTenPhongBan());
        db.update("PhongBan",values,"mapb ='"+phongBanClass.getMaPB() +"'",null);
    }


    public  void Xoa(PhongBanClass phongBanClass)
    {
        SQLiteDatabase db = dbHelperPhongBan.getWritableDatabase();
        String sql ="Delete from PhongBan where mapb= '"+phongBanClass.getMaPB()+"'";
        db.execSQL(sql);
    }
    public ArrayList<PhongBanClass> LayDL()
    {
        ArrayList<PhongBanClass> data = new ArrayList<>();
        String sql="select * from PhongBan";
        SQLiteDatabase db= dbHelperPhongBan.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        try {
            cursor.moveToFirst();
            do {
                PhongBanClass phongBanClass = new PhongBanClass();
                phongBanClass.setMaPB(cursor.getString(0));
                phongBanClass.setTenPhongBan(cursor.getString(1));
                data.add(phongBanClass);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex)
        {
        }
        return  data;
    }


    public ArrayList<PhongBanClass> LayDL(String ma)
    {
        ArrayList<PhongBanClass> data = new ArrayList<>();
        String sql="select * from PhongBan where mapb = '"+ma+"'";
        SQLiteDatabase db= dbHelperPhongBan.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try {
            cursor.moveToFirst();
            do {
                PhongBanClass phongBanClass = new PhongBanClass();
                phongBanClass.setMaPB(cursor.getString(0));
                phongBanClass.setTenPhongBan(cursor.getString(1));
                data.add(phongBanClass);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex)
        {

        }


        return  data;
    }
}
