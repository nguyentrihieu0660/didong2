package com.example.nhomba.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhomba.GiaoDien.ChiTietCC;
import com.example.nhomba.GiaoDien.ChiTietTU;
import com.example.nhomba.Model.ChamCongClass;
import com.example.nhomba.Model.TamUngClass;
import com.example.nhomba.R;

import java.util.ArrayList;


public class CustomApdapterTU extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<TamUngClass> data;
    ArrayList<TamUngClass> data_DS;

    public CustomApdapterTU(Context context, int resource, ArrayList<TamUngClass> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<TamUngClass>();
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
        TextView tvSoPhieu;
        TextView tvNgay;
        TextView tvSoTien;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder = null;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.imgHinh = view.findViewById(R.id.imgHinhTU);
            holder.imgDetail = view.findViewById(R.id.imgDetailTU);
            holder.tvMaNV = view.findViewById(R.id.tvMaNVTU);
            holder.tvSoPhieu = view.findViewById(R.id.tvSoPhieuTU);
            holder.tvNgay = view.findViewById(R.id.tvNgayTU);
            holder.tvSoTien = view.findViewById(R.id.tvSoTienTU);
            view.setTag(holder);
        } else
            holder = (Holder) view.getTag();

        final TamUngClass tamUngClass = data.get(position);

        holder.tvMaNV.setText(tamUngClass.getMaNVTU());
        holder.tvSoPhieu.setText(tamUngClass.getSoPhieu());
        holder.tvNgay.setText(tamUngClass.getNgay());
        holder.tvSoTien.setText(tamUngClass.getSoTien());
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent((Activity) context, ChiTietTU.class);
                Bundle bundle = new Bundle();
                bundle.putString("manvtu", tamUngClass.getMaNVTU());
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
