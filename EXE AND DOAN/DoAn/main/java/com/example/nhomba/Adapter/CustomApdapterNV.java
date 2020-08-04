package com.example.nhomba.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhomba.GiaoDien.ChiTietCC;
import com.example.nhomba.GiaoDien.ChiTietNV;
import com.example.nhomba.GiaoDien.ChiTietTU;
import com.example.nhomba.Model.ChamCongClass;
import com.example.nhomba.Model.NhanVienClass;
import com.example.nhomba.R;

import java.util.ArrayList;


public class CustomApdapterNV extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<NhanVienClass> data;
    ArrayList<NhanVienClass> data_DS;

    public CustomApdapterNV(Context context, int resource, ArrayList<NhanVienClass> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<NhanVienClass>();
        this.data_DS.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        ImageView imgHinh;
        ImageView imgDetail;
        TextView tvMaNV;
        TextView tvHoTen;
        TextView tvNgaySinh;
        TextView tvLuong;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder = null;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.imgHinh = view.findViewById(R.id.imgHinhNV);
            holder.imgDetail = view.findViewById(R.id.imgDetailNV);
            holder.tvMaNV = view.findViewById(R.id.tvMaNV);
            holder.tvHoTen = view.findViewById(R.id.tvHoTenNV);
            holder.tvNgaySinh = view.findViewById(R.id.tvNgaySinhNV);
            holder.tvLuong = view.findViewById(R.id.tvLuongNV);
            view.setTag(holder);
        } else
            holder = (Holder) view.getTag();

        final NhanVienClass nhanVienClass = data.get(position);

        holder.tvMaNV.setText(nhanVienClass.getManv());
        holder.tvHoTen.setText(nhanVienClass.getHoten());
        holder.tvNgaySinh.setText(nhanVienClass.getNgaysinh());
        holder.tvLuong.setText(nhanVienClass.getLuong());
        Bitmap bitmap= BitmapFactory.decodeByteArray(nhanVienClass.getHinhanh(), 0, nhanVienClass.getHinhanh().length);
        holder.imgHinh.setImageBitmap(bitmap);
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent((Activity) context, ChiTietNV.class);
                Bundle bundle = new Bundle();
                bundle.putString("manv", nhanVienClass.getManv());
                intent.putExtras(bundle);
                ((Activity) context).startActivity(intent);


            }
        });


        return view;
    }

    //filter
//    public void filter(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        data.clear();
//        if (charText.length() == 0) {
//            data.addAll(data_DS);
//        } else {
//            for (SinhVien model : data_DS) {
//                if (model.getTenSV().toLowerCase(Locale.getDefault())
//                        .contains(charText)) {
//                    data.add(model);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }

}
