package com.example.appdoctruyentranh.model;

public class TaiKhoan {
    //các biến
    private int nId;
    private String nNameAcc;
    private String nPass;
    private String nMail;
    private int nPhanQuyen;
    //hàm khởi tạo
    public TaiKhoan(String nNameAcc, String nPass, String nMail, int nPhanQuyen) {
        this.nNameAcc = nNameAcc;
        this.nPass = nPass;
        this.nMail = nMail;
        this.nPhanQuyen = nPhanQuyen;
    }

    public TaiKhoan(String nNameAcc, String nMail) {
        this.nNameAcc = nNameAcc;
        this.nMail = nMail;
    }
    //cac getter va setter
    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getnNameAcc() {
        return nNameAcc;
    }

    public void setnNameAcc(String nNameAcc) {
        this.nNameAcc = nNameAcc;
    }

    public String getnPass() {
        return nPass;
    }

    public void setnPass(String nPass) {
        this.nPass = nPass;
    }

    public String getnMail() {
        return nMail;
    }

    public void setnMail(String nMail) {
        this.nMail = nMail;
    }

    public int getnPhanQuyen() {
        return nPhanQuyen;
    }

    public void setnPhanQuyen(int nPhanQuyen) {
        this.nPhanQuyen = nPhanQuyen;
    }
}
