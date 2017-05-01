package com.dsm.onelinefiction;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Item> dataSet;
    private Database database;
    private FloatingActionButton btnAdd;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data load
        firebaseAuth = FirebaseAuth.getInstance();
        database = Database.getInstance(firebaseAuth.getCurrentUser().getUid());

        //view load
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        progressBar = (ProgressBar) findViewById(R.id.prg);

//        layoutManager = new LinearLayoutManager(this);
//        layoutManager = new GridLayoutManager(this, 3);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        dataSet = new ArrayList<>();
        adapter = new MyAdapter(dataSet, this);
        recyclerView.setAdapter(adapter);
        database.setMainViewUpdate(adapter, dataSet, progressBar);

        btnAdd = (FloatingActionButton) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditActivity.class));
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
