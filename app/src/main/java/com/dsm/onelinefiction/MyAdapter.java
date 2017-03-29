package com.dsm.onelinefiction;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Item> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.view_image);
            textView = (TextView) view.findViewById(R.id.view_text);
        }
    }

    public MyAdapter (ArrayList<Item> dataSet) {
        this.dataSet = dataSet;
    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {
        holder.textView.setText(dataSet.get(position).text);
        holder.imageView.setImageResource(dataSet.get(position).image);
    }
    @Override
    public int getItemCount () {
        return dataSet.size();
    }


}
