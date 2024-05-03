package com.example.appdoctruyentranh;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdoctruyentranh.database.databasedoctruyen;

public class DangNhap extends AppCompatActivity {
    EditText etUsername1, etPassword1;
    Button btnLogin;
    TextView tvSingup, tvFogot;
    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        init();
        anhXa();
        setUp();
        setClick();
    }

    private void init() {
    }

    private void anhXa() {
        etUsername1 = findViewById(R.id.etUsername1);
        etPassword1 = findViewById(R.id.etPassword1);
        btnLogin = findViewById(R.id.btnLogin);
        tvFogot = findViewById(R.id.tvForgot);
        tvSingup = findViewById(R.id.tvSignup);
    }

    private void setUp() {
    }

    private void setClick() {
        tvSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DangNhap.this, DangKy.class);
                startActivity(i);
            }
        });
        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taiKhoan=etUsername1.getText().toString();
                String matKhau=etPassword1.getText().toString();
                Cursor cursor= databasedoctruyen.getData();
                while(cursor.moveToNext()){
                    String dataTaiKhoan=cursor.getString(1);
                    String dataMatKhau= cursor.getString(2);
                    if(dataTaiKhoan.equals(taiKhoan) && dataMatKhau.equals(matKhau)){
                        int phanquyen = cursor.getInt(4);
                        int idd=cursor.getInt(0);
                        String email=cursor.getString(3);
                        String nameacc=cursor.getString(1);
                        Intent intent = new Intent(DangNhap.this, MainActivity.class);
                        intent.putExtra("phanq",phanquyen);
                        intent.putExtra("idd",idd);
                        intent.putExtra("email",email);
                        intent.putExtra("tentaikhoan",nameacc);
                        startActivity(intent);
                    }
                }
                cursor.moveToFirst();
                cursor.close();
            }
        });
    }*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DangNhap.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
}