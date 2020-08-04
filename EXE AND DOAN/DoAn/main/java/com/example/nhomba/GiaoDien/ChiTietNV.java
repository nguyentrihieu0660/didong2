package com.example.nhomba.GiaoDien;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.Database.DBNhanVien;
import com.example.nhomba.Database.DBTamUng;
import com.example.nhomba.Model.NhanVienClass;
import com.example.nhomba.Model.TamUngClass;
import com.example.nhomba.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class ChiTietNV extends AppCompatActivity {
    TextView txtMaNhanVien, txtHoTenNhanVien, txtNgaySinhNhanVien,txtLuongNhanVien;
    ArrayList<NhanVienClass> data_TU = new ArrayList<>();
    ImageView imageViewHienThi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietnhanvien);
        setConTrol();
        setEvent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void setEvent() {
        String manv= getIntent().getExtras().getString("manv");
        DBNhanVien dbNhanVien = new DBNhanVien(this);
        data_TU = dbNhanVien.LayDL(manv);
        txtMaNhanVien.setText(data_TU.get(0).getManv());
        txtHoTenNhanVien.setText(data_TU.get(0).getHoten());
        txtNgaySinhNhanVien.setText(data_TU.get(0).getNgaysinh());
        txtLuongNhanVien.setText(data_TU.get(0).getLuong());
        byte[] hinhanh = data_TU.get(0).getHinhanh();

        Bitmap bitmap= BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
        imageViewHienThi.setImageBitmap(bitmap);

    }

    private void setConTrol() {
        txtMaNhanVien = findViewById(R.id.tvmaNhanVien);
        txtHoTenNhanVien = findViewById(R.id.tvHotenNhanVien);
        txtNgaySinhNhanVien = findViewById(R.id.tvNgaySinNhanVien);
        txtLuongNhanVien = findViewById(R.id.tvLuongNhanVien);
        imageViewHienThi = findViewById(R.id.imageViewHienThi);
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