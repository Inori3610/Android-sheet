package com.example.qlxe_php_database;

public class Xe {
    String maxe;
    String tenxe;
    int namsx;
    String maloai;
    String hinh;

    public Xe(String maxe, String tenxe, int namsx, String maloai, String hinh) {
        this.maxe = maxe;
        this.tenxe = tenxe;
        this.namsx = namsx;
        this.maloai = maloai;
        this.hinh = hinh;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public int getNamsx() {
        return namsx;
    }

    public void setNamsx(int namsx) {
        this.namsx = namsx;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }


}
