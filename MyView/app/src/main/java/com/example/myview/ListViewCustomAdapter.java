package com.example.myview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewCustomAdapter extends BaseAdapter {

    String[] comidas;
    Context context;

    ListViewCustomAdapter(Context context, String[] comidas) {

    }

    @Override
    public int getCount() {
        return comidas.length;
    }

    @Override
    public Object getItem(int position) {
        return comidas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_listview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_nome_item = convertView.findViewById(R.id.tv_nome_item);
            viewHolder.imageItem = convertView.findViewById(R.id.imageItem);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_nome_item.setText(comidas[position]);
        viewHolder.imageItem.setBackgroundResource(R.drawable.cat);

        return convertView;
    }

    static class ViewHolder{
        TextView tv_nome_item;
        ImageView imageItem;
    }
}
