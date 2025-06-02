package com.example.php_database_noithat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LoaiNTadapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<LoaiNT> mangloaint;

    public LoaiNTadapter(Context context, int layout, ArrayList<LoaiNT> mangloaint) {
        this.context = context;
        this.layout = layout;
        this.mangloaint = mangloaint;
    }

    @Override
    public int getCount() {
        return mangloaint.size();
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
        TextView txtv_tenloai;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewHolder.txtv_tenloai = convertView.findViewById(R.id.tv_loaint);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        LoaiNT loaiNT = mangloaint.get(i);
        viewHolder.txtv_tenloai.setText(loaiNT.getTenloaiNT());

        return convertView;
    }
}
