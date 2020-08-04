package com.example.nhomba.GiaoDien;

import android.os.Bundle;


import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.Database.DBChamCong;
import com.example.nhomba.Database.DBPhongBan;
import com.example.nhomba.Model.ChamCongClass;
import com.example.nhomba.Model.PhongBanClass;
import com.example.nhomba.R;

import java.util.ArrayList;

public class ChiTietCC extends AppCompatActivity {
    TextView txtMaNV, txtSoNgayCong, txtNgayGhiSo;

    ArrayList<ChamCongClass> data_SV = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietchamcong);
        setConTrol();
        setEvent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void setEvent() {
        String manv= getIntent().getExtras().getString("manv");
        DBChamCong dbChamCong = new DBChamCong(this);
        data_SV = dbChamCong.LayDL(manv);
        txtMaNV.setText(data_SV.get(0).getMaNV());
        txtNgayGhiSo.setText(data_SV.get(0).getNgayGhiSo());
        txtSoNgayCong.setText(data_SV.get(0).getSoNgayCong());

    }

    private void setConTrol() {
        txtMaNV = findViewById(R.id.tvMaNVCCchitiet);
        txtNgayGhiSo = findViewById(R.id.tvngayGhiSoCCchitiet);
        txtSoNgayCong = findViewById(R.id.tvSoNgayCongCCchitiet);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}