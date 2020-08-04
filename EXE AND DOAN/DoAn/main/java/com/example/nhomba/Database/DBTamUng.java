package com.example.nhomba.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhomba.GiaoDien.TamUng;
import com.example.nhomba.Model.PhongBanClass;
import com.example.nhomba.Model.TamUngClass;

import java.util.ArrayList;

public class DBTamUng {
    DBHelperTamUng dbHelperTamUng;

    public DBTamUng(Context context) {
        dbHelperTamUng= new DBHelperTamUng(context);
    }

    public void Them(TamUngClass tamUngClass)
    {
        SQLiteDatabase db = dbHelperTamUng.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("manvtu",tamUngClass.getMaNVTU());
        values.put("sophieu",tamUngClass.getSoPhieu());
        values.put("ngay",tamUngClass.getNgay());
        values.put("sotien",tamUngClass.getSoTien());
        db.insert("TamUng",null,values);
    }

    public  void Sua(TamUngClass tamUngClass)
    {

        SQLiteDatabase db = dbHelperTamUng.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("manvtu",tamUngClass.getMaNVTU());
        values.put("sophieu",tamUngClass.getSoPhieu());
        values.put("ngay",tamUngClass.getNgay());
        values.put("sotien",tamUngClass.getSoTien());
        db.update("tamUng",values,"manvtu ='"+tamUngClass.getMaNVTU() +"'",null);
    }



    public  void Xoa(TamUngClass tamUngClass)
    {
        SQLiteDatabase db = dbHelperTamUng.getWritableDatabase();
        String sql ="Delete from TamUng where manvtu= '"+tamUngClass.getMaNVTU()+"'";
        db.execSQL(sql);
    }
    public ArrayList<TamUngClass> LayDL()
    {
        ArrayList<TamUngClass> data = new ArrayList<>();
        String sql="select * from TamUng";
        SQLiteDatabase db= dbHelperTamUng.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        try {
            cursor.moveToFirst();
            do {
                TamUngClass tamUngClass = new TamUngClass();
                tamUngClass.setMaNVTU(cursor.getString(0));
                tamUngClass.setSoPhieu(cursor.getString(1));
                tamUngClass.setNgay(cursor.getString(2));
                tamUngClass.setSoTien(cursor.getString(3));
                data.add(tamUngClass);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex)
        { }
        return  data;
    }


    public ArrayList<TamUngClass> LayDL(String ma)
    {
        ArrayList<TamUngClass> data = new ArrayList<>();
        String sql="select * from TamUng where manvtu = '"+ma+"'";
        SQLiteDatabase db= dbHelperTamUng.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try {
            cursor.moveToFirst();
            do {
                TamUngClass tamUngClass = new TamUngClass();
                tamUngClass.setMaNVTU(cursor.getString(0));
                tamUngClass.setSoPhieu(cursor.getString(1));
                tamUngClass.setNgay(cursor.getString(2));
                tamUngClass.setSoTien(cursor.getString(3));
                data.add(tamUngClass);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex)
        {

        }


        return  data;
    }
}
