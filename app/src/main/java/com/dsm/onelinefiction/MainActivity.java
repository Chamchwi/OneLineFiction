package com.dsm.onelinefiction;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
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

//        layoutManager = new LinearLayoutManager(this);
//        layoutManager = new GridLayoutManager(this, 3);
        layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        dataSet = new ArrayList<>();
        adapter = new MyAdapter(dataSet);
        recyclerView.setAdapter(adapter);

        //뷰 표시

        dataSet.add(new Item("1", R.mipmap.ic_launcher));
        dataSet.add(new Item("2", R.mipmap.ic_launcher));
        dataSet.add(new Item("3", R.mipmap.ic_launcher));
        dataSet.add(new Item("4", R.mipmap.ic_launcher));
        Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show();

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
        Toast.makeText(this, "Restart", Toast.LENGTH_SHORT).show();
//        for (int i = 0; i < Book.getInstance().pageList.size(); i++)
//            dataSet.add(new Item(Book.getInstance().pageList.get(i).page_title, R.mipmap.ic_launcher));
    }
}
