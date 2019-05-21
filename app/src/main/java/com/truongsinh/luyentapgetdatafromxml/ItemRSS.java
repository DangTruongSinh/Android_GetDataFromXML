package com.truongsinh.luyentapgetdatafromxml;

public class ItemRSS {
    String tieude;
    String noidung;

    public ItemRSS(String tieude, String noidung) {
        this.tieude = tieude;
        this.noidung = noidung;
    }
    public ItemRSS() {

    }
    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
