package com.example.appdoctruyentranh.model;

public class AppTruyen {
    private int ID;
    private String NameTruyen;
    private String NoiDung;
    private String Image;
    private int ID_ACC;

    public AppTruyen(String nameTruyen, String noiDung, String image, int ID_ACC) {
        NameTruyen = nameTruyen;
        NoiDung = noiDung;
        Image = image;
        this.ID_ACC = ID_ACC;
    }

    public AppTruyen(int ID, String nameTruyen, String noiDung, String image, int ID_ACC) {
        this.ID = ID;
        NameTruyen = nameTruyen;
        NoiDung = noiDung;
        Image = image;
        this.ID_ACC = ID_ACC;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNameTruyen() {
        return NameTruyen;
    }

    public void setNameTruyen(String nameTruyen) {
        NameTruyen = nameTruyen;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getID_ACC() {
        return ID_ACC;
    }

    public void setID_ACC(int ID_ACC) {
        this.ID_ACC = ID_ACC;
    }
}

