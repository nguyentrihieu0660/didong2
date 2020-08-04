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

import com.example.nhomba.GiaoDien.ChiTietPB;
import com.example.nhomba.Model.PhongBanClass;
import com.example.nhomba.R;

import java.util.ArrayList;
import java.util.Locale;



public class CustomApdapterPB extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<PhongBanClass> data;
    ArrayList<PhongBanClass> data_DS;

    public CustomApdapterPB(Context context, int resource, ArrayList<PhongBanClass> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<PhongBanClass>();
        this.data_DS.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        ImageView imgHinh;
        ImageView imgDetail;
        TextView tvMaPB;
        TextView tvTenPhongBan;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder = null;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.imgHinh = view.findViewById(R.id.imgHinhPB);
            holder.imgDetail = view.findViewById(R.id.imgDetailPB);
            holder.tvMaPB = view.findViewById(R.id.tvMaPB1);
            holder.tvTenPhongBan = view.findViewById(R.id.tvTenPB1);
            view.setTag(holder);
        } else
            holder = (Holder) view.getTag();

        final PhongBanClass phongBanClass = data.get(position);

        holder.tvMaPB.setText(phongBanClass.getMaPB());
        holder.tvTenPhongBan.setText(phongBanClass.getTenPhongBan());
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent((Activity) context, ChiTietPB.class);
                Bundle bundle = new Bundle();
                bundle.putString("mapb", phongBanClass.getMaPB());
                intent.putExtras(bundle);
                ((Activity) context).startActivity(intent);

            }
        });


        return view;
    }

//    //filter
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
