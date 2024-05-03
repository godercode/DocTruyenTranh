package com.example.appdoctruyentranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.appdoctruyentranh.adapter.TruyenTranhAdapter;
import com.example.appdoctruyentranh.api.ApiLayAnh;
import com.example.appdoctruyentranh.interfaces.LayAnhVe;
import com.example.appdoctruyentranh.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DocTruyenActivity extends AppCompatActivity implements LayAnhVe {
 ImageView imgAnh, imgBack;
 ArrayList<String> arrURLAnh;
 int soTrang, soTrangDangDoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_truyen);
        init();
        anhXa();
        setUp();
        setClick();
        new ApiLayAnh(this).execute();
    }
    private void init(){
        Bundle b= getIntent().getBundleExtra("data");
        TruyenTranh truyenTranh = (TruyenTranh) b.getSerializable("truyen");

    }
    private void anhXa(){
        imgAnh=findViewById(R.id.imgAnh);
        imgBack=findViewById(R.id.imgBack);
    }
    private void setUp(){
        //docTheoTrang(0);
    }
    private void setClick(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DocTruyenActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void left(View view) {
        docTheoTrang(-1);
    }

    public void right(View view) {
        docTheoTrang(1);
    }
    private void docTheoTrang(int i){
        soTrangDangDoc=soTrangDangDoc+i;
        if(soTrangDangDoc==0){
            soTrangDangDoc=1;
        }
        if(soTrangDangDoc>soTrang){
            soTrangDangDoc=soTrang;
        }
        Glide.with(this).load(arrURLAnh.get(soTrangDangDoc-1)).into(imgAnh);
    }

    @Override
    public void batDau() {

    }

    @Override
    public void ketThuc(String data) {
        arrURLAnh= new ArrayList<>();
        try{
            JSONArray arr= new JSONArray(data);
            for(int i=0; i<arr.length(); i++){
                arrURLAnh.add(arr.getString(i));
            }
            soTrangDangDoc=1;
            soTrang=arrURLAnh.size();
            docTheoTrang(0);
            }catch (JSONException e){

        }
    }

    @Override
    public void biLoi() {

    }
}