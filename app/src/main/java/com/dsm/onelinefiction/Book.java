package com.dsm.onelinefiction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book {

    private String book_title;
    private String book_content;
    private String book_date_create;
    private String book_date_update;

    public Book (String title, String content) {
        this.book_title = title;
        this.book_content = content;

        Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        this.book_date_create = (new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초").format(date));
    }
}
