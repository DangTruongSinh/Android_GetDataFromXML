package com.truongsinh.luyentapgetdatafromxml;

public class Item {
    int hinh;
    String stt;

    public Item(int hinh, String stt) {
        this.hinh = hinh;
        this.stt = stt;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }
}
