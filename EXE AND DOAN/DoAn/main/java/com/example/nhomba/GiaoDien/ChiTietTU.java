package com.example.nhomba.GiaoDien;

import android.os.Bundle;

import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.Database.DBChamCong;
import com.example.nhomba.Database.DBTamUng;
import com.example.nhomba.Model.ChamCongClass;
import com.example.nhomba.Model.TamUngClass;
import com.example.nhomba.R;

import java.util.ArrayList;

public class ChiTietTU extends AppCompatActivity {
    TextView txtMaNVTU, txtSoPhieu, txtNgay,txtSoTien;
    ArrayList<TamUngClass> data_TU = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitiettamung);
        setConTrol();
        setEvent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void setEvent() {
        String manvtu= getIntent().getExtras().getString("manvtu");
        DBTamUng dbTamUng = new DBTamUng(this);
        data_TU = dbTamUng.LayDL(manvtu);
        txtMaNVTU.setText(data_TU.get(0).getMaNVTU());
        txtSoPhieu.setText(data_TU.get(0).getSoPhieu());
        txtNgay.setText(data_TU.get(0).getNgay());
        txtSoTien.setText(data_TU.get(0).getSoTien());
    }

    private void setConTrol() {
        txtMaNVTU = findViewById(R.id.tvmaTU);
        txtSoPhieu = findViewById(R.id.tvSophieuTU);
        txtNgay = findViewById(R.id.tvngayTamung);
        txtSoTien = findViewById(R.id.tvsoTienTamUng);

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