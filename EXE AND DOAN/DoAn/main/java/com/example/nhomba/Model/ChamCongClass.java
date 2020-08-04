package com.example.nhomba.Model;

public class ChamCongClass {
    String maNV, ngayGhiSo, soNgayCong;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayGhiSo() {
        return ngayGhiSo;
    }

    public void setNgayGhiSo(String ngayGhiSo) {
        this.ngayGhiSo = ngayGhiSo;
    }

    public String getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(String soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    @Override
    public String toString() {
        return "ChamCongClass{" +
                "maNV='" + maNV + '\'' +
                ", ngayGhiSo='" + ngayGhiSo + '\'' +
                ", soNgayCong='" + soNgayCong + '\'' +
                '}';
    }
}
