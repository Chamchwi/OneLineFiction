package com.dsm.onelinefiction;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Page implements Serializable {

    public String page_title;
    public String page_content;
    public String page_date_create;
    public String page_date_update;

    public Page() {
        //파이어베이스 데이터베이스에서 값을 불러오기 위해 필수로 사용
    }

    public Page(String title, String content) {
        this.page_title = title;
        this.page_content = content;

        Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();

        this.page_date_create = (new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초").format(date));
        this.page_date_update = "";
    }

    public Page(String title, String content, String createDate) {
        this.page_title = title;
        this.page_content = content;

        Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();

        this.page_date_create = createDate;
        this.page_date_update = (new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초").format(date));
    }
}
