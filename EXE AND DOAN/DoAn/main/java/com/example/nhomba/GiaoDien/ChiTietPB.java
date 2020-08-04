package com.example.nhomba.GiaoDien;

import android.annotation.SuppressLint;
import android.os.Bundle;


import android.view.MenuItem;
import android.widget.TextView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.Database.DBPhongBan;
import com.example.nhomba.Model.PhongBanClass;
import com.example.nhomba.R;

import java.util.ArrayList;

public class ChiTietPB extends AppCompatActivity {
    TextView txtMaPB, txtTenPB;
    ArrayList<PhongBanClass> data_SV = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietphongban);
        setConTrol();
        setEvent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void setEvent() {
        String mapb= getIntent().getExtras().getString("mapb");
        DBPhongBan dbPhongBan = new DBPhongBan(this);
        data_SV = dbPhongBan.LayDL(mapb);
        txtMaPB.setText(data_SV.get(0).getMaPB());
        txtTenPB.setText(data_SV.get(0).getTenPhongBan());
    }

    private void setConTrol() {
        txtMaPB = findViewById(R.id.tvmaPBChiTiet);
        txtTenPB = findViewById(R.id.tvtenPBChiTiet);

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