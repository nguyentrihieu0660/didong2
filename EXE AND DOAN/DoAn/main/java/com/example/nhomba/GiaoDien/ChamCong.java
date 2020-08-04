package com.example.nhomba.GiaoDien;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;



import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.Adapter.CustomApdapterCC;
import com.example.nhomba.Database.DBChamCong;
import com.example.nhomba.Database.DBTamUng;
import com.example.nhomba.Model.ChamCongClass;
import com.example.nhomba.Model.TamUngClass;
import com.example.nhomba.R;

import java.util.ArrayList;

public class ChamCong extends AppCompatActivity {

    Button btnThem, btnXoa, btnThoat,btnSUa;
    EditText txtMaSV, txtNgayGhiSo, txtSoNgayCong;
    GridView gvDanhSachChamCong;


    CustomApdapterCC apdapter ;
    ArrayList<ChamCongClass> data_SV = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamcong);
        setConTrol();
        setEvent();
    }

    private void setEvent() {
        HienThiDL();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDL();
                HienThiDL();
            }
        });
        btnSUa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuaDL();
                HienThiDL();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaDL();
                HienThiDL();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thoat();
            }
        });
    }
    private void Thoat(){
        Intent intent = new Intent(ChamCong.this, MainActivity.class);
        startActivity(intent);
    }
    private  void HienThiDL()
    {
        DBChamCong dbChamCong = new DBChamCong(this);
        data_SV = dbChamCong.LayDL();
        apdapter = new CustomApdapterCC(this,R.layout.giadienhienthichamcong,data_SV);
        gvDanhSachChamCong.setAdapter(apdapter);
    }

    private  void ThemDL()
    {
        DBChamCong dbChamCong = new DBChamCong(this);

        ChamCongClass chamCongClass = new ChamCongClass();
        chamCongClass.setMaNV(txtMaSV.getText().toString());
        chamCongClass.setNgayGhiSo(txtNgayGhiSo.getText().toString());
        chamCongClass.setSoNgayCong(txtSoNgayCong.getText().toString());
        dbChamCong.Them(chamCongClass);


    }
    private void SuaDL()
    {
        DBChamCong dbChamCong = new DBChamCong(getApplicationContext());
        ChamCongClass chamCongClass = new ChamCongClass();
        chamCongClass.setMaNV(txtMaSV.getText().toString());
        chamCongClass.setNgayGhiSo(txtNgayGhiSo.getText().toString());
        chamCongClass.setSoNgayCong(txtSoNgayCong.getText().toString());
        dbChamCong.Sua(chamCongClass);
    }
    private void XoaDL()
    {
        DBChamCong dbChamCong = new DBChamCong(getApplicationContext());
        ChamCongClass chamCongClass = new ChamCongClass();
        chamCongClass.setMaNV(txtMaSV.getText().toString());
        chamCongClass.setNgayGhiSo(txtNgayGhiSo.getText().toString());
        chamCongClass.setSoNgayCong(txtSoNgayCong.getText().toString());

        dbChamCong.Xoa(chamCongClass);
    }

    private void setConTrol() {
        btnXoa = findViewById(R.id.btnXoa);
        btnSUa = findViewById(R.id.btnSua);
        btnThem = findViewById(R.id.btnThem);
        btnThoat = findViewById(R.id.btnThoat);
        txtMaSV = findViewById(R.id.tvMaSVCC);
        txtNgayGhiSo = findViewById(R.id.tvNgayGhiSo);
        txtSoNgayCong = findViewById(R.id.tvSoNgayCong);
        gvDanhSachChamCong = findViewById(R.id.gvDanhSachChamCong);


    }


}