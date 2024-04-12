package com.example.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListViewCustomAdapter extends BaseAdapter {
    Context context;
    String[] planetas;
    String[] luas;

    ListViewCustomAdapter(Context context, String[] planetas, String[] luas){
        this.context = context;
        this.planetas = planetas;
        this.luas = luas;
    }

    public int getCount(){
        return planetas.length;
    }

    public Object getItem(int position){
        return planetas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listlayout, parent, false);

            holder = new ViewHolder();
            holder.tv_item1 = convertView.findViewById(R.id.tv_item1);
            holder.tv_item2 = convertView.findViewById(R.id.tv_item2);
            holder.iv_item = convertView.findViewById(R.id.iv_item);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_item1.setText(planetas[position]);
        holder.tv_item2.setText(luas[position]);

        switch (position) {
            case 0:
                holder.iv_item.setBackgroundResource(R.drawable.mercurio);
                break;
            case 1:
                holder.iv_item.setBackgroundResource(R.drawable.venus);
                break;
            case 2:
                holder.iv_item.setBackgroundResource(R.drawable.terra);
                break;
            case 3:
                holder.iv_item.setBackgroundResource(R.drawable.marte);
                break;
            case 4:
                holder.iv_item.setBackgroundResource(R.drawable.jupiter);
                break;
            case 5:
                holder.iv_item.setBackgroundResource(R.drawable.saturno);
                break;
            case 6:
                holder.iv_item.setBackgroundResource(R.drawable.urano);
                break;
            case 7:
                holder.iv_item.setBackgroundResource(R.drawable.netuno);
                break;
            default:
                break;
        }

        return convertView;
    }

    static class ViewHolder{
        TextView tv_item1;
        TextView tv_item2;
        ImageView iv_item;
    }
}
