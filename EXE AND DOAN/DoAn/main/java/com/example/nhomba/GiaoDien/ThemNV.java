package com.example.nhomba.GiaoDien;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.Adapter.CustomApdapterNV;
import com.example.nhomba.Adapter.CustomApdapterPB;
import com.example.nhomba.Adapter.CustomApdapterTU;
import com.example.nhomba.Database.DBNhanVien;
import com.example.nhomba.Database.DBPhongBan;
import com.example.nhomba.Database.DBTamUng;
import com.example.nhomba.Model.NhanVienClass;
import com.example.nhomba.Model.PhongBanClass;
import com.example.nhomba.Model.TamUngClass;
import com.example.nhomba.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class ThemNV extends AppCompatActivity {

    Button btnThem, btnThoat,btnDanhSachNV;
    EditText txtManv, txtHoTen,txtNgaySinh,txtLuong;
    private ImageView ImageViewCamera,ImageViewFolder, ImageViewHinhAnh;
    int REQUEST_CODE_CAMERA = 123;
    int REQUEST_CODE_FOLDER = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themnv);
        setConTrol();
        setEvent();
    }

    private void setEvent() {
        ImageViewCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE_CAMERA);
            }
        });
        ImageViewFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_FOLDER);
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDL();
                Intent intent = new Intent(ThemNV.this,BangLuong.class);
                startActivity(intent);
            }
        });
        btnDanhSachNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemNV.this,BangLuong.class);
                startActivity(intent);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thoat();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ImageViewHinhAnh.setImageBitmap(bitmap);
        }
        if(requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                ImageViewHinhAnh.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public byte[] ConverttoArrayByte(ImageView img)
    {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
        Bitmap bitmap=bitmapDrawable.getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
private  void ThemDL()
{
    DBNhanVien dbNhanVien = new DBNhanVien(this);
    dbNhanVien.Them(txtManv.getText().toString(),
            txtHoTen.getText().toString(),
            txtNgaySinh.getText().toString(),
            txtLuong.getText().toString(),ConverttoArrayByte(ImageViewHinhAnh));
    Toast.makeText(ThemNV.this, "Đã thêm!!!", Toast.LENGTH_LONG).show();
}
    private void setConTrol() {
        btnThem = findViewById(R.id.btnThem);
        btnThoat = findViewById(R.id.btnThoatThemNV);
        txtManv = findViewById(R.id.tvMaNVDS);
        txtHoTen = findViewById(R.id.tvHoTenNVDS);
        txtNgaySinh = findViewById(R.id.tvNgaySinhNVDS);
        txtLuong = findViewById(R.id.tvLuongNVDS);
        btnDanhSachNV = findViewById(R.id.btnDanhSachNV);
        ImageViewCamera = findViewById(R.id.imageViewCamera);
        ImageViewFolder = findViewById(R.id.imageViewFolder);
        ImageViewHinhAnh = findViewById(R.id.imageViewHinhAnh);

    }

    private void Thoat(){
        Intent intent = new Intent(ThemNV.this, MainActivity.class);
        startActivity(intent);
    }



}