package com.dsm.onelinefiction;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class EditActivity extends AppCompatActivity {

    private Database database;
    private EditText edtTitle;
    private EditText edtContent;
    private Button btnSubmit;
    private FirebaseAuth firebaseAuth;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        intent = getIntent();
        final boolean isModify = getIntent().getBooleanExtra("isModify", false);

        //load view
        edtTitle = (EditText) findViewById(R.id.edt_title);
        edtContent = (EditText) findViewById(R.id.edt_content);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        getSupportActionBar().setTitle("의식의 흐름대로 일기 쓰기");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (isModify) { //새로 작성이 아닌 수정인 경우
            edtTitle.setText(((Page) intent.getSerializableExtra("page")).page_title);
            edtContent.setText(((Page) intent.getSerializableExtra("page")).page_content);
        }

        //load databse
        firebaseAuth = FirebaseAuth.getInstance();
        database = Database.getInstance(firebaseAuth.getCurrentUser().getUid());
        firebaseAuth = FirebaseAuth.getInstance();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isModify) {
                    Page page = new Page(edtTitle.getText().toString(), edtContent.getText().toString());
                    database.createNewBook(page);
                    Toast.makeText(EditActivity.this, "의식의 흐름대로 작성한 일기가\n" +
                            "정상적으로 등록되었습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Page page = new Page(
                            edtTitle.getText().toString(),
                            edtContent.getText().toString(),
                            ((Page) intent.getSerializableExtra("page")).page_date_create);
                    database.modifyBook(page, intent.getIntExtra("index", -1));
                    Toast.makeText(EditActivity.this, "정상적으로 수정되었습니다.", Toast.LENGTH_SHORT).show();
                }
                finish();
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
