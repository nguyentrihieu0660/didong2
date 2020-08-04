package com.example.nhomba.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperTamUng extends SQLiteOpenHelper {

    public DBHelperTamUng(Context context) {
        super(context, "QLTamUng", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table TamUng(manvtu text ,sophieu text, ngay text, sotien text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
