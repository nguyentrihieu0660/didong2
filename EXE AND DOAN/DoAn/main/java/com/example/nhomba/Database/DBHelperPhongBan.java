package com.example.nhomba.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperPhongBan extends SQLiteOpenHelper {

    public DBHelperPhongBan( Context context) {
        super(context, "QLPhongBan", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table PhongBan(mapb text ,tenphongban text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
