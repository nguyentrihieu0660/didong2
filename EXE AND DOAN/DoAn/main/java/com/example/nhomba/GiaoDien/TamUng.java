package com.example.nhomba.GiaoDien;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.Adapter.CustomApdapterPB;
import com.example.nhomba.Adapter.CustomApdapterTU;
import com.example.nhomba.Database.DBPhongBan;
import com.example.nhomba.Database.DBTamUng;
import com.example.nhomba.Model.PhongBanClass;
import com.example.nhomba.Model.TamUngClass;
import com.example.nhomba.R;

import java.util.ArrayList;

public class TamUng extends AppCompatActivity {

    Button btnThem, btnXoa, btnThoat,btnSUa;
    EditText txtManv, txtSoPhieu,txtNgay,txtSoTien;
    GridView gvDanhSachTamUng;

    CustomApdapterTU apdapter ;
    ArrayList<TamUngClass> data_SV = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamung);
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
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaDL();
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

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thoat();
            }
        });
    }
    private void Thoat(){
        Intent intent = new Intent(TamUng.this, MainActivity.class);
        startActivity(intent);
    }
    private void HienThiDL()
    {
        DBTamUng dbTamUng = new DBTamUng(this);
        data_SV = dbTamUng.LayDL();
        apdapter = new CustomApdapterTU(this,R.layout.giadienhienthitamung,data_SV);
        gvDanhSachTamUng.setAdapter(apdapter);
    }

    private  void ThemDL()
    {
        DBTamUng dbTamUng = new DBTamUng(this);
        TamUngClass tamUngClass = new TamUngClass();
        tamUngClass.setMaNVTU(txtManv.getText().toString());
        tamUngClass.setSoPhieu(txtSoPhieu.getText().toString());
        tamUngClass.setNgay(txtNgay.getText().toString());
        tamUngClass.setSoTien(txtSoTien.getText().toString());
        dbTamUng.Them(tamUngClass);
    }
    private void SuaDL()
    {
        DBTamUng dbTamUng = new DBTamUng(getApplicationContext());
        TamUngClass tamUngClass = new TamUngClass();
        tamUngClass.setMaNVTU(txtManv.getText().toString());
        tamUngClass.setNgay(txtNgay.getText().toString());
        tamUngClass.setSoPhieu(txtSoPhieu.getText().toString());
        tamUngClass.setSoTien(txtSoTien.getText().toString());
        dbTamUng.Sua(tamUngClass);
    }
    private void XoaDL()
    {
        DBTamUng dbTamUng = new DBTamUng(getApplicationContext());
        TamUngClass tamUngClass = new TamUngClass();
        tamUngClass.setMaNVTU(txtManv.getText().toString());
        tamUngClass.setNgay(txtNgay.getText().toString());
        tamUngClass.setSoPhieu(txtSoPhieu.getText().toString());
        tamUngClass.setSoTien(txtSoTien.getText().toString());

        dbTamUng.Xoa(tamUngClass);
    }

    private void setConTrol() {
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSUa = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        gvDanhSachTamUng = findViewById(R.id.gvDanhSachTamUng);
        txtManv = findViewById(R.id.tvMaSVTU);
        txtNgay = findViewById(R.id.tvNgay);
        txtSoPhieu = findViewById(R.id.tvSoPhieu);
        txtSoTien = findViewById(R.id.tvSoTien);
    }


}