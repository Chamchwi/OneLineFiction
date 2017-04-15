package com.dsm.onelinefiction;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Database {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private static Database instance;

    public Database(String userId) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(userId);
        databaseReference.addValueEventListener(valueEventListener);
    }

    public static Database getInstance(String userId) {
        if (instance == null)
            instance = new Database(userId);

        return instance;
    }

    public void checkFirst() {

    }

    //새로운 일기 작성
    public void createNewBook(String userId, Page page) {
        Book book = Book.getInstance();
        book.addPage(page);
        databaseReference.setValue(book);
    }

    //기존 일기 내용 수정
    public void modifyBook() {

    }

    //일기 삭제
    public void removeBook() {

    }

    private ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            Book book = dataSnapshot.getValue(Book.class);
            Book.getInstance().pageList = book.pageList;
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };
}
