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
import com.example.nhomba.Model.ChamCongClass;
import com.example.nhomba.R;

import java.util.ArrayList;
import java.util.Locale;


public class CustomApdapterCC extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<ChamCongClass> data;
    ArrayList<ChamCongClass> data_DS;

    public CustomApdapterCC(Context context, int resource, ArrayList<ChamCongClass> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<ChamCongClass>();
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
        TextView tvNgayGhiSo;
        TextView tvSoNgayCong;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder = null;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.imgHinh = view.findViewById(R.id.imgHinhCC);
            holder.imgDetail = view.findViewById(R.id.imgDetailCC);
            holder.tvMaNV = view.findViewById(R.id.tvMaNV1);
            holder.tvNgayGhiSo = view.findViewById(R.id.tvNgayGhiSo1);
            holder.tvSoNgayCong = view.findViewById(R.id.tvSoNgayCong1);
            view.setTag(holder);
        } else
            holder = (Holder) view.getTag();

        final ChamCongClass chamCongClass = data.get(position);

        holder.tvMaNV.setText(chamCongClass.getMaNV());
        holder.tvNgayGhiSo.setText(chamCongClass.getNgayGhiSo());
        holder.tvSoNgayCong.setText(chamCongClass.getSoNgayCong());
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent((Activity) context, ChiTietCC.class);
                Bundle bundle = new Bundle();
                bundle.putString("manv", chamCongClass.getMaNV());
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
