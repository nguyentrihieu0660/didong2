package com.example.nhomba.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperNhanVien extends SQLiteOpenHelper {

    public DBHelperNhanVien(Context context) {
        super(context, "QLNhanVien", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = ("Create Table If not Exists NhanVien(ID Integer Primary Key Autoincrement, MaNV Varchar, HoTen Varchar,NgaySinh Varchar,SoLuong Varchar, Hinhanh Blob)");
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
