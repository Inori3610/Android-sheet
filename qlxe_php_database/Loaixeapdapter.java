package com.example.qlxe_php_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Loaixeapdapter extends BaseAdapter {

    Context context;
    int mylayout;
    ArrayList<Loaixe> mangloaixe;

    public Loaixeapdapter(Context context, int mylayout, ArrayList<Loaixe> mangloaixe) {
        this.context = context;
        this.mylayout = mylayout;
        this.mangloaixe = mangloaixe;
    }

    @Override
    public int getCount() {
        return mangloaixe.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    private class ViewHolder{
        TextView txttvTenloaixe;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(mylayout,null);
            viewHolder.txttvTenloaixe = (TextView) convertView.findViewById(R.id.txt);
            convertView.setTag(viewHolder);
        } else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        Loaixe loaixe = mangloaixe.get(i);
        viewHolder.txttvTenloaixe.setText(loaixe.getTenloai());
        return convertView;
    }


}
