package com.example.appdoctruyentranh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.object.TruyenTranh;

import java.util.ArrayList;
import java.util.List;

public class TruyenTranhAdapter extends ArrayAdapter<TruyenTranh> {
    private Context ct;
    private ArrayList<TruyenTranh> arr;
    public TruyenTranhAdapter(@NonNull Context context, int resource, @NonNull List<TruyenTranh> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr=new ArrayList<>(objects);
    }
    //Sắp xếp truyện mục tìm
    public void sortTruyen(String s){
        s=s.toUpperCase();
        int k=0;
        for(int i=0; i<arr.size(); i++){
            TruyenTranh t= arr.get(i);
            String ten = t.getTenTruyen().toUpperCase();
            if(ten.indexOf(s)>0){
                arr.set(i,arr.get(k));
                arr.set(k,t);
                k++;
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_item_truyen, null);
        }
        if (arr.size()>0){
            TruyenTranh truyenTranh = this.arr.get(position);
            TextView tenTenTruyen=convertView.findViewById(R.id.tvTenTruyen);
            TextView tenTenChap=convertView.findViewById(R.id.tvTenChap);
            ImageView imgAnhTruyen=convertView.findViewById(R.id.imgAnhTruyen);

            tenTenTruyen.setText(truyenTranh.getTenTruyen());
            tenTenChap.setText(truyenTranh.getTenChap());
            Glide.with(this.ct).load(truyenTranh.getLinkAnh()).into(imgAnhTruyen);
        }
        return convertView;
    }
}
