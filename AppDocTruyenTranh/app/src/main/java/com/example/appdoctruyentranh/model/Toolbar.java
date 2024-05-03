package com.example.appdoctruyentranh.model;

public class Toolbar {

    private String tenchuyenmuc;
    private int hinhanhchuyenmuc;

    public Toolbar(String tenchuyenmuc, int hinhanhchuyenmuc) {
        this.tenchuyenmuc = tenchuyenmuc;
        this.hinhanhchuyenmuc = hinhanhchuyenmuc;
    }


    public String getTenchuyenmuc() {

        return tenchuyenmuc;
    }

    public void setTenchuyenmuc(String tenchuyenmuc) {
        this.tenchuyenmuc = tenchuyenmuc;
    }

    public int getHinhanhchuyenmuc() {

        return hinhanhchuyenmuc;
    }

    public void setHinhanhchuyenmuc(int hinhanhchuyenmuc) {
        this.hinhanhchuyenmuc = hinhanhchuyenmuc;
    }
}
