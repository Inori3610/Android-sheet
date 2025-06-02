package com.example.php_database_noithat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NoithatAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Noithat> mangnoithat;

    public NoithatAdapter(Context context, int layout, ArrayList<Noithat> mangnoithat) {
        this.context = context;
        this.layout = layout;
        this.mangnoithat = mangnoithat;
    }

    @Override
    public int getCount() {
        return mangnoithat.size();
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
        TextView txtv_ten,txtv_dvt,txtv_soluong,txtv_dongia;
        ImageView hinhanh;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,parent,false);
            viewHolder.txtv_ten =(TextView) convertView.findViewById(R.id.tv_ten);
            viewHolder.txtv_dvt =(TextView) convertView.findViewById(R.id.tv_dtv);
            viewHolder.txtv_soluong =(TextView) convertView.findViewById(R.id.tv_soluong);
            viewHolder.txtv_dongia = (TextView) convertView.findViewById(R.id.tv_dongia);
            viewHolder.hinhanh = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);

        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Noithat noithat = mangnoithat.get(i);
        viewHolder.txtv_ten.setText(noithat.getTennoithat());
        viewHolder.txtv_dvt.setText(noithat.getDonvitinh());
        viewHolder.txtv_soluong.setText(String.valueOf(noithat.getSoluong()));
        viewHolder.txtv_dongia.setText(String.valueOf(noithat.getDongia()));

        Log.d("IMAGE_DEBUG", "Loading Noithat image: " + noithat.getHinhanh());

        Picasso.get().load(noithat.getHinhanh()).resize(300,300).into(viewHolder.hinhanh);


        return convertView;
    }
}
