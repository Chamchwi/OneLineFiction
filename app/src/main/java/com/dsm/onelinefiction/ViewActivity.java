package com.dsm.onelinefiction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewActivity extends AppCompatActivity {

    private Intent intent;
    private Page page;

    private TextView txt_title;
    private TextView txt_content;
    private TextView txt_date_create;
    private TextView txt_date_update;
    private Button btn_delete;
    private Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //page data load
        intent = getIntent();
        page = (Page) intent.getSerializableExtra("page");

        //View load
        getSupportActionBar().setTitle(page.page_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_content = (TextView) findViewById(R.id.txt_content);
        txt_date_create = (TextView) findViewById(R.id.txt_date_create);
        txt_date_update = (TextView) findViewById(R.id.txt_date_update);

        txt_title.setText(page.page_title);
        txt_content.setText(page.page_content);
        txt_date_create.setText(page.page_date_create);
        txt_date_update.setText(page.page_date_update);
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
