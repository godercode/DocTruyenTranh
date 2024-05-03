package com.example.appdoctruyentranh;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdoctruyentranh.database.databasedoctruyen;
import com.example.appdoctruyentranh.model.TaiKhoan;

public class DangKy extends AppCompatActivity {
    EditText etUsername, etPassword, etEmail;
    Button btnSingin;
    TextView tvSingup;
    databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        init();
        anhXa();
        setUp();
        setClick();
    }
    private void init(){}
    private void anhXa(){
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPasswword);
        etUsername=findViewById(R.id.etEmail);
        btnSingin=findViewById(R.id.btnSingin);
        tvSingup=findViewById(R.id.tvSignup);
    }
    private void setUp(){
    }
    private void setClick(){
        tvSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DangKy.this, DangNhap.class);
                startActivity(intent);
            }
        });
        btnSingin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = etUsername.getText().toString();
                String matkhau = etPassword.getText().toString();
                String email = etEmail.getText().toString();
                TaiKhoan taiKhoan1 = CreateTK();
                if(taikhoan.equals("") || matkhau.equals("") || email.equals("")){
                    Log.e("Thông báo:","Chưa nhập đầy đủ thông tin!");
                }
                //Nếu đúng thì add vào database
                else{
                    databasedoctruyen.AddTaiKhoan(taiKhoan1);
                    Toast.makeText(DangKy.this,"Đăng Ký Thành Công!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private TaiKhoan CreateTK() {
        String taikhoan = etUsername.getText().toString();
        String matkhau = etPassword.getText().toString();
        String email = etEmail.getText().toString();
        int phanquyen = 1;
        TaiKhoan tk = new TaiKhoan(taikhoan,matkhau,email,phanquyen);
        return tk;
    }
}