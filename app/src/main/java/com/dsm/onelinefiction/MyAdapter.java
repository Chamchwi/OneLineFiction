package com.dsm.onelinefiction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import javax.crypto.spec.DESedeKeySpec;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Item> dataSet;
    protected static Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);
            imageView = (ImageView) view.findViewById(R.id.view_image);
            textView = (TextView) view.findViewById(R.id.view_text);
        }

        @Override
        public void onClick(View v) {
            Book book = Book.getInstance();
            Intent intent = new Intent(context, ViewActivity.class);
            intent.putExtra("page", book.pageList.get(book.pageList.size() - 1 - getPosition()));
            intent.putExtra("index", book.pageList.size() - 1 - getPosition());
            context.startActivity(intent);
        }
    }

    public MyAdapter(ArrayList<Item> dataSet, Context context) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(dataSet.get(position).text);
        holder.imageView.setImageResource(dataSet.get(position).image);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
