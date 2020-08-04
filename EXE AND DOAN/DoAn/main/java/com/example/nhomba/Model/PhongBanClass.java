package com.example.nhomba.Model;

public class PhongBanClass {
    String maPB, tenPhongBan;

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    @Override
    public String toString() {
        return "PhongBanClass{" +
                "maPB='" + maPB + '\'' +
                ", tenPhongBan='" + tenPhongBan + '\'' +
                '}';
    }
}
