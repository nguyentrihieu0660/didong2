package com.example.nhomba.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhomba.Model.ChamCongClass;

import java.util.ArrayList;

public class DBChamCong {
    DBHelperChamcong dbHelperChamcong;

    public DBChamCong(Context context) {
       dbHelperChamcong = new DBHelperChamcong(context);
    }

    public void Them(ChamCongClass chamCongClass)
    {
        SQLiteDatabase db = dbHelperChamcong.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masv",chamCongClass.getMaNV());
        values.put("ngayghiso",chamCongClass.getNgayGhiSo());
        values.put("songaycong",chamCongClass.getSoNgayCong());
        db.insert("ChamCong",null,values);
    }

    public  void Sua(ChamCongClass chamCongClass)
    {
        SQLiteDatabase db = dbHelperChamcong.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masv",chamCongClass.getMaNV());
        values.put("ngayghiso",chamCongClass.getNgayGhiSo());
        values.put("songaycong",chamCongClass.getSoNgayCong());
        db.update("ChamCong",values,"masv ='"+chamCongClass.getMaNV() +"'",null);
    }


    public  void Xoa(ChamCongClass chamCongClass)
    {
        SQLiteDatabase db = dbHelperChamcong.getWritableDatabase();
        String sql ="Delete from ChamCong where masv= '"+chamCongClass.getMaNV()+"'";
        db.execSQL(sql);
    }
    public ArrayList<ChamCongClass> LayDL()
    {
        ArrayList<ChamCongClass> data = new ArrayList<>();
        String sql="select * from ChamCong";
        SQLiteDatabase db= dbHelperChamcong.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        try {
            cursor.moveToFirst();
            do {
                ChamCongClass chamCongClass = new ChamCongClass();
                chamCongClass.setMaNV(cursor.getString(0));
                chamCongClass.setNgayGhiSo(cursor.getString(1));
                chamCongClass.setSoNgayCong(cursor.getString(2));
                data.add(chamCongClass);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex)
        {
        }
        return  data;
    }


    public ArrayList<ChamCongClass> LayDL(String ma)
    {
        ArrayList<ChamCongClass> data = new ArrayList<>();
        String sql="select * from ChamCong where masv = '"+ma+"'";
        SQLiteDatabase db= dbHelperChamcong.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try {
            cursor.moveToFirst();
            do {
                ChamCongClass chamCongClass = new ChamCongClass();
                chamCongClass.setMaNV(cursor.getString(0));
                chamCongClass.setNgayGhiSo(cursor.getString(1));
                chamCongClass.setSoNgayCong(cursor.getString(2));
                data.add(chamCongClass);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex)
        {

        }
        return  data;
    }
}
