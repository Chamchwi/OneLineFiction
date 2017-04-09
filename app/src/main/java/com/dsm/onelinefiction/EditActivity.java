package com.dsm.onelinefiction;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private Database database;
    private EditText edtTitle;
    private EditText edtContent;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        database = Database.getInstance();
        edtTitle = (EditText) findViewById(R.id.edt_title);
        edtContent = (EditText) findViewById(R.id.edt_content);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book(edtTitle.getText().toString(), edtContent.getText().toString());
            }
        });
    }
}
