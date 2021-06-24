package com.example.samsungproject;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private final ArrayList<ItemClass> myList;

    public Adapter(ArrayList<ItemClass> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemClass item = myList.get(position);
        holder.imageView_img.setImageResource(item.getImg());
        holder.textView_title.setText(item.getTitle());
        holder.textView_desc.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView_img;
        public TextView textView_title;
        public TextView textView_desc;
        // INTERFACE-------------
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView_img = itemView.findViewById(R.id.const_img);
            textView_title = itemView.findViewById(R.id.const_title);
            textView_desc = itemView.findViewById(R.id.const_desc);

        }
    }
}
