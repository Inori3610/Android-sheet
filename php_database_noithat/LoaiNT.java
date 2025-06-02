package com.example.php_database_noithat;

public class LoaiNT {
    String maloaiNT;
    String tenloaiNT;

    public LoaiNT(String maloaiNT, String tenloaiNT) {
        this.maloaiNT = maloaiNT;
        this.tenloaiNT = tenloaiNT;
    }

    public String getTenloaiNT() {
        return tenloaiNT;
    }

    public void setTenloaiNT(String tenloaiNT) {
        this.tenloaiNT = tenloaiNT;
    }

    public String getMaloaiNT() {
        return maloaiNT;
    }

    public void setMaloaiNT(String maloaiNT) {
        this.maloaiNT = maloaiNT;
    }
}
