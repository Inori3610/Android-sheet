package com.example.php_database_noithat;

public class Noithat {
    String manoithat;
    String tennoithat;
    String donvitinh;
    int soluong;
    int dongia;
    String maloaiNT;
    String hinhanh;

    public Noithat(String manoithat, String tennoithat, String donvitinh, int soluong, int dongia, String maloaiNT, String hinhanh) {
        this.manoithat = manoithat;
        this.tennoithat = tennoithat;
        this.donvitinh = donvitinh;
        this.soluong = soluong;
        this.dongia = dongia;
        this.maloaiNT = maloaiNT;
        this.hinhanh = hinhanh;
    }

    public String getManoithat() {
        return manoithat;
    }

    public void setManoithat(String manoithat) {
        this.manoithat = manoithat;
    }

    public String getTennoithat() {
        return tennoithat;
    }

    public void setTennoithat(String tennoithat) {
        this.tennoithat = tennoithat;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getMaloaiNT() {
        return maloaiNT;
    }

    public void setMaloaiNT(String maloaiNT) {
        this.maloaiNT = maloaiNT;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
