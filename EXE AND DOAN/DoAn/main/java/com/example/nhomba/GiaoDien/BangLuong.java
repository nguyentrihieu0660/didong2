package com.example.nhomba.GiaoDien;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;



import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.Adapter.CustomApdapterNV;
import com.example.nhomba.Database.DBNhanVien;
import com.example.nhomba.Model.NhanVienClass;
import com.example.nhomba.R;

import java.util.ArrayList;

public class BangLuong extends AppCompatActivity {

    Button btnThoat,btnXoa,btnSua;
    EditText txtManv, txtHoTen,txtNgaySinh,txtLuong;
    GridView gvDanhSachNV;
    CustomApdapterNV apdapter ;
    ArrayList<NhanVienClass> data_SV = new ArrayList<>();
    DBNhanVien dbNhanVien = new DBNhanVien(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach);
        setConTrol();
        setEvent();
    }

    private void setEvent() {
        HienThiDL();

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thoat();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaDL();
                HienThiDL();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuaDL();
                HienThiDL();
            }
        });
        gvDanhSachNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                NhanVienClass nhanVienClass = data_SV.get(position);
                txtManv.setText(String.valueOf(nhanVienClass.getManv()));
                txtHoTen.setText(nhanVienClass.getHoten());
                txtNgaySinh.setText(nhanVienClass.getNgaysinh());
                txtLuong.setText(nhanVienClass.getLuong());
                txtManv.setEnabled(false);
            }
        });
        gvDanhSachNV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            int aa;
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                aa = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(BangLuong.this);
                builder.setTitle("Thông Báo !!!");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Bạn Muốn Thoát ?");
                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NhanVienClass nhanVienClass = data_SV.get(aa);
                        dbNhanVien.Xoa(nhanVienClass.getManv());
                        HienThiDL();
                        Toast.makeText(BangLuong.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        });

    }
    private void Thoat(){
        Intent intent = new Intent(BangLuong.this, MainActivity.class);
        startActivity(intent);
    }
    private void HienThiDL()
    {
        DBNhanVien dbNhanVien = new DBNhanVien(this);
        data_SV = dbNhanVien.LayDL();
        apdapter = new CustomApdapterNV(this,R.layout.giadienhienthinhanvien,data_SV);
        gvDanhSachNV.setAdapter(apdapter);
    }
    private void SuaDL()
    {
        DBNhanVien dbNhanVien = new DBNhanVien(getApplicationContext());
        NhanVienClass nhanVienClass = new NhanVienClass(this);
        nhanVienClass.setManv(txtManv.getText().toString());
        nhanVienClass.setHoten(txtHoTen.getText().toString());
        nhanVienClass.setNgaysinh(txtNgaySinh.getText().toString());
        nhanVienClass.setLuong(txtLuong.getText().toString());
        dbNhanVien.Sua(nhanVienClass);
    }
    private void XoaDL()
    {
        dbNhanVien = new DBNhanVien(this);
        dbNhanVien.Xoa(txtManv.getText().toString());
        Toast.makeText(BangLuong.this, "Đã xóa thành công!!!", Toast.LENGTH_LONG).show();

    }

    private void setConTrol() {
        btnThoat = findViewById(R.id.btnThoat);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        txtManv = findViewById(R.id.tvMaNVDS);
        txtHoTen = findViewById(R.id.tvHoTenNVDS);
        txtNgaySinh = findViewById(R.id.tvNgaySinhNVDS);
        txtLuong = findViewById(R.id.tvLuongNVDS);
        gvDanhSachNV = findViewById(R.id.gvDanhSachNV);
    }

}