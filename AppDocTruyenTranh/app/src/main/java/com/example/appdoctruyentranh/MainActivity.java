package com.example.appdoctruyentranh;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdoctruyentranh.adapter.TruyenTranhAdapter;
import com.example.appdoctruyentranh.api.ApiLayTruyen;
import com.example.appdoctruyentranh.interfaces.LayTruyenVe;
import com.example.appdoctruyentranh.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LayTruyenVe {
GridView gdvDSTruyen;
EditText etTimkiem;
TruyenTranhAdapter adapter;
ArrayList<TruyenTranh> truyenTranhArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
        new ApiLayTruyen(this).execute();
    }
    private void init(){
        truyenTranhArrayList=new ArrayList<>();

        adapter= new TruyenTranhAdapter(this,0,truyenTranhArrayList);
    }
    private void anhXa(){
        gdvDSTruyen=findViewById(R.id.gdvDSTruyen);
        etTimkiem=findViewById(R.id.etTiemkiem);
    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick(){
        etTimkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String t = etTimkiem.getText().toString();
                adapter.sortTruyen(t);
            }
        });
        gdvDSTruyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TruyenTranh truyenTranh =truyenTranhArrayList.get(position);
                Bundle b= new Bundle();
                b.putSerializable("truyen",truyenTranh);
                Intent intent = new Intent(MainActivity.this,DocTruyenActivity.class);
                intent.putExtra("data",b);
                startActivity(intent);
            }
        });
    }

    @Override
    public void batDau() {
        Toast.makeText(this,"Đang lấy về",Toast.LENGTH_LONG).show();
    }

    @Override
    public void ketThuc(String data) {
        try{
            truyenTranhArrayList.clear();
            JSONArray arr= new JSONArray(data);
            for(int i=0; i<arr.length(); i++){
                JSONObject o= arr.getJSONObject(i);
                truyenTranhArrayList.add(new TruyenTranh(o));
            }
            adapter= new TruyenTranhAdapter(this,0,truyenTranhArrayList);
            gdvDSTruyen.setAdapter(adapter);
        }catch(JSONException e){

        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this,"Lỗi kết nối",Toast.LENGTH_LONG).show();
    }
}