package com.example.exemplos;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerAdapterItens {
    package com.example.myrecycleview;

    public class menu {
        private String name;
        private String description;
        private int imageResource;

        public menu(String name, String description, int imageResource) {
            this.name = name;
            this.description = description;
            this.imageResource = imageResource;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getImageResource() {
            return imageResource;
        }
    }

    package com.example.myrecycleview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class menuArrayAdapter extends RecyclerView.Adapter<menuArrayAdapter.ViewHolder> {
        private int listItemLayout;
        private ArrayList<menu> menuList;

        public menuArrayAdapter(int layoutId, ArrayList<menu> menuList) {
            listItemLayout = layoutId;
            this.menuList = menuList;
        }

        public int getItemCount() {
            return menuList == null ? 0 : menuList.size();
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
            ViewHolder myViewHolder = new ViewHolder(view);
            return myViewHolder;
        }

        public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
            TextView menuName = holder.menuName;
            TextView menuDescription = holder.menuDescription;
            ImageView itemImage = holder.itemImage;

            menuName.setText(menuList.get(listPosition).getName());
            menuDescription.setText(menuList.get(listPosition).getDescription());
            itemImage.setImageResource(menuList.get(listPosition).getImageResource());
        }

        static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView menuName;
            public TextView menuDescription;

            public ImageView itemImage;

            public ViewHolder(View menuView) {
                super(menuView);
                menuView.setOnClickListener(this);
                menuName = menuView.findViewById(R.id.tv_item);
                menuDescription = menuView.findViewById(R.id.tv_des);
                itemImage = menuView.findViewById(R.id.im_menu_item);
            }

            public void onClick(View view) {
                Toast.makeText(view.getContext(), "D-" + menuName.getText(), Toast.LENGTH_SHORT).show();
                Log.d("onclick", "onClick" + getLayoutPosition() + " " + menuName.getText());
            }
        }
    }
}
