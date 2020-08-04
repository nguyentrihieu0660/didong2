package com.example.nhomba.GiaoDien;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.Adapter.CustomApdapterNV;
import com.example.nhomba.Database.DBChamCong;
import com.example.nhomba.Database.DBNhanVien;
import com.example.nhomba.Model.ChamCongClass;
import com.example.nhomba.Model.NhanVienClass;
import com.example.nhomba.R;

import java.util.ArrayList;

public class DanhSach extends AppCompatActivity {

    Button btnThoat;
    EditText txtManv, txtHoTen,txtNgaySinh,txtLuong;
    GridView gvDanhSachNV;
    CustomApdapterNV apdapter ;
    ArrayList<NhanVienClass> data_SV = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach);
        setConTrol();
        setEvent();
    }

    private void setEvent() {
        HienThiDL();



    }
    private void HienThiDL()
    {
        DBNhanVien dbNhanVien = new DBNhanVien(this);
        data_SV = dbNhanVien.LayDL();
        apdapter = new CustomApdapterNV(this,R.layout.giadienhienthinhanvien,data_SV);
        gvDanhSachNV.setAdapter(apdapter);
    }

    private  void ThemDL()
    {
//        DBNhanVien dbNhanVien = new DBNhanVien(this);
//        NhanVienClass nhanVienClass = new NhanVienClass();
//        nhanVienClass.setManv(txtManv.getText().toString());
//        nhanVienClass.setHoten(txtHoTen.getText().toString());
//        nhanVienClass.setNgaysinh(txtNgaySinh.getText().toString());
//        nhanVienClass.setLuong(txtLuong.getText().toString());
//        dbNhanVien.Them(nhanVienClass);
    }



    private void setConTrol() {
        btnThoat = findViewById(R.id.btnThoat);

        txtManv = findViewById(R.id.tvMaNVDS);
        txtHoTen = findViewById(R.id.tvHoTenNVDS);
        txtNgaySinh = findViewById(R.id.tvNgaySinhNVDS);
        txtLuong = findViewById(R.id.tvLuongNVDS);
        gvDanhSachNV = findViewById(R.id.gvDanhSachNV);
    }
}