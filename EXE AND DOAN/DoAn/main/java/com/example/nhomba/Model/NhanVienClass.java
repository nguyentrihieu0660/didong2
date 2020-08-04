package com.example.nhomba.Model;

import com.example.nhomba.GiaoDien.BangLuong;

public class NhanVienClass {
    public NhanVienClass(BangLuong bangLuong) {
    }

    public byte[] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }

    public NhanVienClass(String string, String string1, String string2, String string3, byte[] blob) {
        this.manv= string;
        this.hoten = string1;
        this.ngaysinh = string2;
        this.luong = string3;
        this.hinhanh = blob;
    }
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    String manv, hoten, ngaysinh, luong;
    byte[] hinhanh;
    @Override
    public String toString() {
        return "NhanVienClass{" +
                "manv='" + manv + '\'' +
                ", hoten='" + hoten + '\'' +
                ", ngaysinh='" + ngaysinh + '\'' +
                ", luong='" + luong + '\'' +
                '}';
    }
}
