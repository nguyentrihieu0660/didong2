package com.example.nhomba.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperChamcong extends SQLiteOpenHelper {

    public DBHelperChamcong(Context context) {
        super(context, "QLChamCong", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table ChamCong(masv text ,ngayghiso text, songaycong text )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
