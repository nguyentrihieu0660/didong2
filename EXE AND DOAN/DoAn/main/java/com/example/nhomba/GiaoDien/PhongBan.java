package com.example.nhomba.GiaoDien;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.Adapter.CustomApdapterPB;
import com.example.nhomba.Database.DBPhongBan;
import com.example.nhomba.Database.DBTamUng;
import com.example.nhomba.Model.PhongBanClass;
import com.example.nhomba.R;

import java.util.ArrayList;



public class PhongBan extends AppCompatActivity {

    Button btnThem, btnXoa, btnThoat,btnSUa;
    EditText txtMaPhongBan, txtTenPhongBan;
    GridView gvDanhSachPhongBan;
    int index = -1;
    CustomApdapterPB apdapter ;
    ArrayList<PhongBanClass> data_PB = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phongban);
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
        Intent intent = new Intent(PhongBan.this, MainActivity.class);
        startActivity(intent);
    }
    private void HienThiDL()
    {
        DBPhongBan dbPhongBan = new DBPhongBan(this);
        data_PB = dbPhongBan.LayDL();
        apdapter = new CustomApdapterPB(this,R.layout.giaodienhienthiphongban,data_PB);
        gvDanhSachPhongBan.setAdapter(apdapter);

    }

    private  void ThemDL()
    {
        DBPhongBan dbPhongBan = new DBPhongBan(this);
        PhongBanClass phongBan = new PhongBanClass();
        phongBan.setMaPB(txtMaPhongBan.getText().toString());
        phongBan.setTenPhongBan(txtTenPhongBan.getText().toString());
        dbPhongBan.Them(phongBan);
    }
    private void SuaDL()
    {
        DBPhongBan dbPhongBan = new DBPhongBan(getApplicationContext());
        PhongBanClass phongBanClass = new PhongBanClass();
        phongBanClass.setMaPB(txtMaPhongBan.getText().toString());
        phongBanClass.setTenPhongBan(txtTenPhongBan.getText().toString());
        dbPhongBan.Sua(phongBanClass);
    }
    private void XoaDL()
    {
        DBPhongBan dbPhongBan = new DBPhongBan(getApplicationContext());
        PhongBanClass phongBanClass = new PhongBanClass();
        phongBanClass.setMaPB(txtMaPhongBan.getText().toString());
        phongBanClass.setTenPhongBan(txtTenPhongBan.getText().toString());

        dbPhongBan.Xoa(phongBanClass);
    }
    private void setConTrol() {
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSUa = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        gvDanhSachPhongBan = findViewById(R.id.gvDanhSachPhongBan);
        txtMaPhongBan = findViewById(R.id.tvMaPB1);
        txtTenPhongBan = findViewById(R.id.tvTenPB1);
    }
}
