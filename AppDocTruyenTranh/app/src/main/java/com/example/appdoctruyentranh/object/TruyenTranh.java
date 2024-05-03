package com.example.appdoctruyentranh.object;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class TruyenTranh implements Serializable {
    private String tenTruyen, tenChap, linkAnh;

    public TruyenTranh() {
    }
    public TruyenTranh(JSONObject o) throws JSONException{
        tenTruyen =o.getString("tenTruyen");
        tenChap=o.getString("tenChap");
        linkAnh=o.getString("linkAnh");
    }

    public TruyenTranh(String tenTruyen, String tenChap, String lịnkAnh) {
        this.tenTruyen = tenTruyen;
        this.tenChap = tenChap;
        this.linkAnh = lịnkAnh;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getTenChap() {
        return tenChap;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String lịnkAnh) {
        this.linkAnh = lịnkAnh;
    }
}
