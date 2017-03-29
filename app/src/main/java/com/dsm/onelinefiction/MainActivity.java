package com.dsm.onelinefiction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Item> dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dataSet = new ArrayList<>();
        adapter = new MyAdapter (dataSet);
        recyclerView.setAdapter(adapter);

        dataSet.add(new Item("1", R.mipmap.ic_launcher));
        dataSet.add(new Item("2", R.mipmap.ic_launcher));
        dataSet.add(new Item("3", R.mipmap.ic_launcher));
    }
}
