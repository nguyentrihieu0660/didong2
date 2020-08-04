package com.example.nhomba.Model;

public class TamUngClass {
    String maNVTU, soPhieu, ngay, soTien;

    public String getMaNVTU() {
        return maNVTU;
    }

    public void setMaNVTU(String maNVTU) {
        this.maNVTU = maNVTU;
    }

    public String getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }

    @Override
    public String toString() {
        return "TamUngClass{" +
                "maNVTU='" + maNVTU + '\'' +
                ", soPhieu='" + soPhieu + '\'' +
                ", ngay='" + ngay + '\'' +
                ", soTien='" + soTien + '\'' +
                '}';
    }
}
