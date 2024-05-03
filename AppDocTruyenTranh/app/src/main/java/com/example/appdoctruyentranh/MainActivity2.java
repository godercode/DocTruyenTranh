package com.example.appdoctruyentranh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.appdoctruyentranh.adapter.adapterMenu;
import com.example.appdoctruyentranh.api.ApiLayTruyen;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import com.example.appdoctruyentranh.adapter.TruyenTranhAdapter;
import com.example.appdoctruyentranh.interfaces.LayTruyenVe;
import com.example.appdoctruyentranh.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity implements LayTruyenVe {
 Toolbar toolBar;
 DrawerLayout drawerLayout;
 NavigationView navigationView;
 ListView listView;
 ViewFlipper viewFlipper;
 TruyenTranhAdapter adapter;
 ArrayList<TruyenTranh> truyenTranhArrayList;
 ArrayList<Toolbar> arrayList;
 adapterMenu adapterMenu;
 GridView gdvDSTruyen;
 EditText etTimkiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhXa();
        actionToolBar();
        ActionViewFlipper();
        init();
        anhXa();
        setUp();
        setClick();
        ationMenu();
        new ApiLayTruyen(this).execute();
    }

    private void ationMenu() {
        arrayList = new ArrayList<>();
        arrayList.add(new Toolbar("Thêm Bài",R.drawable.ic_baseline_post_add_24));
        arrayList.add(new Toolbar("Tìm Kiếm",R.drawable.ic_baseline_image_search_24));
        arrayList.add(new Toolbar("Đăng Xuất",R.drawable.ic_baseline_login_24));
        adapterMenu = new adapterMenu(this,R.layout.chuyenmuc,arrayList);
        listView.setAdapter(adapterMenu);
    }

    private void init(){
        truyenTranhArrayList=new ArrayList<>();
        adapter= new TruyenTranhAdapter(this,0,truyenTranhArrayList);
    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick() {
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
                Intent intent = new Intent(MainActivity2.this,DocTruyenActivity.class);
                intent.putExtra("data",b);
                startActivity(intent);
            }
        });
    }
    private void actionToolBar() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolBar.setNavigationIcon(R.drawable.ic_action_menu);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void ActionViewFlipper() {
        //mảng chữ tấm ảnh cho quảng cáo
        ArrayList<String> quangcao = new ArrayList<>();
        //add ảnh vào mảng
        quangcao.add("https://imgproxy4.tinhte.vn/qfzM8JJccCzvvfnP0PhKHRzU9ih_RVXNew44JEoJlxc/w:600/plain/http://www.dtv-ebook.com/images/truyen-online/ebook-tru-tien-prc-pdf-epub.jpg");
        quangcao.add("https://static.8cache.com/cover/o/eJzLyTDW160wTC70dXI0zAnO1g9LL0gpsAz0CA_x1HeEAqckR31jj0A_n_Jg8ygXC_1yI0NT3QxjIyNdz2QTIwCuMBMz/linh-vu-thien-ha.jpg");
        quangcao.add("https://static.8cache.com/cover/o/eJzLyTDT1y1Mcw2M0C0IMAvL1g9z8nUxMYwyD3Tz1HeEgmwfR_0SAzefTKOgCI8MC_1yI0NT3QxjIyMANhQRaQ==/truyen-dau-pha-thuong-khung.jpg");
        quangcao.add("https://static.8cache.com/cover/o/eJzLyTDR1430dbb0NfWMd7MM1A9z8nWxDDLx8En11HeEgmzffH1ny6h4g_SkpNBAX_1yI0NT3QxjIyMAJDgRVA==/vu-dong-can-khon.jpg");
        //Thực hiện vòng lặp for gắn ảnh vào ImageView, rồi chuyển lên app
        for (int i=0; i<quangcao.size(); i++){
            ImageView imageview = new ImageView(getApplicationContext());
            //Sử dụng hàm thư viện Picasso
            Glide.with(this).load(quangcao.get(i)).into(imageview);
            //phương thức chỉnh tấm hình vừa khung quảng cáo
            imageview.setScaleType(ImageView.ScaleType.FIT_XY);
            //Thêm ảnh từ imageview vài viewflipper
            viewFlipper.addView(imageview);
        }
        //Thiết lập tự chạy cho viewflipper chạy trong 5s
        viewFlipper.setFlipInterval(5000);
        //chạy tự động flipper
        viewFlipper.setAutoStart(true);
        //gọi amination cho vào và ra
        Animation animation_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.in_right);
        Animation animation_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.out_right);
        //Gọi animation vào viewflipper
        viewFlipper.setInAnimation(animation_in);
        viewFlipper.setInAnimation(animation_out);

    }
    private void anhXa(){
        toolBar= findViewById(R.id.toolbarmain);
        drawerLayout=findViewById(R.id.drawerlayout);
        navigationView=findViewById(R.id.navigationNew);
        listView = findViewById(R.id.listviewmainchinh);
        viewFlipper=findViewById(R.id.viewflipper);
        gdvDSTruyen=findViewById(R.id.gdvDSTruyen);
        etTimkiem=findViewById(R.id.etTiemkiem);
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