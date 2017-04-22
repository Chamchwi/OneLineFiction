package com.dsm.onelinefiction;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Book {

    public List<Page> pageList;
    private static Book instance;

    public Book() {
        
    }

    public void addPage(Page page) {
        if (pageList == null)
            pageList = new ArrayList<>();

        pageList.add(page);
    }

    public static Book getInstance() {
        if (instance == null)
            instance = new Book();

        return instance;
    }
}
