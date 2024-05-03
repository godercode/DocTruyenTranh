package com.example.appdoctruyentranh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.model.Toolbar;
import java.util.List;

public class adapterMenu extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Toolbar> chuyenmuc;

    public adapterMenu(Context context, int layout, List<Toolbar> toolbarList) {
        this.context = context;
        this.layout = layout;
        this.chuyenmuc = toolbarList;
    }

    @Override
    public int getCount() {
        return chuyenmuc.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    //các chuyên mục ở thanh toolbar
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        ImageView img = (ImageView) convertView.findViewById(R.id.imgchuyemuc);
        TextView txt = (TextView) convertView.findViewById(R.id.Tenchuyenmuc);
        Toolbar tt = chuyenmuc.get(position);
        txt.setText(tt.getTenchuyenmuc());
        //Picasso.get().load(tt.getHinhanhchuyenmuc()).placeholder(R.drawable.ic_baseline_rotate_left_24).error(R.drawable.ic_baseline_image_search_24);
        img.setImageResource(tt.getHinhanhchuyenmuc());
        return convertView;

    }
}
