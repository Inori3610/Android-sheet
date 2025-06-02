package com.example.qlxe_php_database;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import com.squareup.picasso.Picasso;


public class Xeadapter extends BaseAdapter {
    Context mycontext;
    int mylayout;
    ArrayList<Xe> mangxe;

    public Xeadapter(Context context, int mylayout, ArrayList<Xe> mangxe) {
        this.mycontext = context;
        this.mylayout = mylayout;
        this.mangxe = mangxe;
    }

    @Override
    public int getCount() {
        return mangxe.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtvTenxe,txtvNamsx;
        ImageView imghinh;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(mylayout,null);
            viewHolder.txtvTenxe=(TextView) convertView.findViewById(R.id.textViewTenxe);
            viewHolder.txtvNamsx=(TextView) convertView.findViewById(R.id.textViewNamsx);
            viewHolder.imghinh=(ImageView) convertView.findViewById(R.id.imageViewHinh);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Xe xe = mangxe.get(i);
        viewHolder.txtvTenxe.setText(xe.getTenxe());
        viewHolder.txtvNamsx.setText(String.valueOf(xe.getNamsx()));

        Picasso.get().load(xe.getHinh()).resize(300, 300).into(viewHolder.imghinh);

        return convertView;
    }




}
