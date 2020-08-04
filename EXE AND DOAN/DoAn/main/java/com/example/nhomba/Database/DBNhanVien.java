package com.example.nhomba.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.example.nhomba.Model.NhanVienClass;

import java.util.ArrayList;

public class DBNhanVien {
    DBHelperNhanVien dbHelperNhanVien;

    public DBNhanVien(Context context) {
        dbHelperNhanVien = new DBHelperNhanVien(context);
    }

    public void Them(String manv, String hoten, String ngaysinh, String soluong, byte[] hinhanh)
    {
        SQLiteDatabase db = dbHelperNhanVien.getWritableDatabase();
        String sql = "INSERT INTO NhanVien VALUES (null,?,?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,manv);
        statement.bindString(2,hoten);
        statement.bindString(3,ngaysinh);
        statement.bindString(4,soluong);
        statement.bindBlob(5,hinhanh);
        statement.executeInsert();
    }

    Cursor TruyVanTraVe(String sql)
    {
        SQLiteDatabase db= dbHelperNhanVien.getWritableDatabase();
        return db.rawQuery(sql,null);
    }

    public ArrayList<NhanVienClass> LayDL()
    {
        ArrayList<NhanVienClass> data = new ArrayList<>();
        String sql="select * from nhanvien";
        SQLiteDatabase db= dbHelperNhanVien.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            data.add(new NhanVienClass(cursor.getString(1),cursor.getString(2),cursor.getString(3), cursor.getString(4), cursor.getBlob(5)));
        }
        return  data;
    }

    public  void Sua(NhanVienClass nhanVienClass)
    {
        SQLiteDatabase db = dbHelperNhanVien.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaNV",nhanVienClass.getManv());
        values.put("HoTen",nhanVienClass.getHoten());
        values.put("NgaySinh",nhanVienClass.getNgaysinh());
        values.put("SoLuong",nhanVienClass.getLuong());
        db.update("NhanVien",values,"MaNV ='"+nhanVienClass.getManv() +"'",null);
    }


    public  void Xoa(String ma)
    {

        SQLiteDatabase db = dbHelperNhanVien.getWritableDatabase();
        String sql ="Delete from NhanVien where MaNV= '"+ma+"' ";
        db.execSQL(sql);

    }

//    public ArrayList<NhanVienClass> LayDL()
//    {
//        ArrayList<NhanVienClass> data = new ArrayList<>();
//        String sql="select * from NhanVien";
//        SQLiteDatabase db= dbHelperNhanVien.getReadableDatabase();
//        Cursor cursor = db.rawQuery(sql,null);
//
//        try {
//            cursor.moveToFirst();
//            do {
//                NhanVienClass nhanVienClass = new NhanVienClass();
//                nhanVienClass.setManv(cursor.getString(0));
//                nhanVienClass.setHoten(cursor.getString(1));
//                nhanVienClass.setNgaysinh(cursor.getString(2));
//                nhanVienClass.setLuong(cursor.getString(3));
//                data.add(nhanVienClass);
//            }
//            while (cursor.moveToNext());
//        }
//        catch (Exception ex)
//        {
//
//        }
//
//
//        return  data;
//    }


    public ArrayList<NhanVienClass> LayDL(String ma)
    {
        ArrayList<NhanVienClass> data = new ArrayList<>();
        String sql="select * from NhanVien where MaNV = '"+ma+"'";
        SQLiteDatabase db= dbHelperNhanVien.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            data.add(new NhanVienClass(cursor.getString(1),cursor.getString(2),cursor.getString(3), cursor.getString(4), cursor.getBlob(5)));
        }
        return  data;
    }
}
