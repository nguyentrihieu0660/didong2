package com.example.nhomba.GiaoDien;



import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.R;

public class MainActivity extends AppCompatActivity {
    Button btnThemNV, btnChamCong, btnBangLuong, btnPhongBan, btnThoat, btnTamUng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnThemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThemNV.class);
                startActivity(intent);
            }
        });

        btnBangLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BangLuong.class);
                startActivity(intent);
            }
        });


        btnChamCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChamCong.class);
                startActivity(intent);
            }
        });

        btnTamUng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TamUng.class);
                startActivity(intent);
            }
        });

        btnPhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhongBan.class);
                startActivity(intent);
            }
        });
//        btnLac.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MainSensor.class);
//                startActivity(intent);
//            }
//        });
//
//        btnGiaiTri.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MainVe.class);
//                startActivity(intent);
//            }
//        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Thoat();
            }
        });
    }

    private void Thoat(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Thông Báo !!!");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Bạn Muốn Thoát ?");
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              finish();
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
    }
    private void setControl() {
        btnThemNV = findViewById(R.id.btnThemNV);
        btnBangLuong = findViewById(R.id.btnBangLuong);
        btnChamCong = findViewById(R.id.btnChamCong);
        btnTamUng = findViewById(R.id.btnTamUng);
        btnPhongBan = findViewById(R.id.btnPhongBan);
        btnThoat = findViewById(R.id.btnThoat);

    }
}