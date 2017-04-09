package com.dsm.onelinefiction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Database {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private static Database instance;

    public Database() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.addValueEventListener(valueEventListener);
    }

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();

        return instance;
    }

    //새로운 일기 작성
    public void createNewBook (Book book) {

    }
    //기존 일기 내용 수정
    public void modifyBook () {

    }
    //일기 삭제
    public void removeBook () {

    }

    private ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };
}
