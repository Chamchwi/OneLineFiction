package com.dsm.onelinefiction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class ViewActivity extends AppCompatActivity {

    private Intent intent;
    private Page page;
    private int index;

    private TextView txt_title;
    private TextView txt_content;
    private TextView txt_date_create;
    private TextView txt_date_update;
    private Spinner spn_option;

    private FirebaseAuth firebaseAuth;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //page data load
        intent = getIntent();
        page = (Page) intent.getSerializableExtra("page");
        index = intent.getIntExtra("index", 0);

        //View load
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_content = (TextView) findViewById(R.id.txt_content);
        txt_date_create = (TextView) findViewById(R.id.txt_date_create);
        txt_date_update = (TextView) findViewById(R.id.txt_date_update);
        spn_option = (Spinner) findViewById(R.id.spn_option);

        txt_title.setText(page.page_title);
        txt_content.setText(page.page_content);
        txt_date_create.setText(page.page_date_create);
        txt_date_update.setText(page.page_date_update);

        firebaseAuth = FirebaseAuth.getInstance();
        database = Database.getInstance(firebaseAuth.getCurrentUser().getUid());

        spn_option.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1: //수정
                        Intent intent = new Intent(ViewActivity.this, EditActivity.class);
                        intent.putExtra("page", page);
                        intent.putExtra("index", index);
                        intent.putExtra("isModify", true);
                        startActivity(intent);
                        finish();
                        break;
                    case 2: //삭제
                        database.removeBook(index);
                        Toast.makeText(ViewActivity.this, "글을 삭제하였습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
