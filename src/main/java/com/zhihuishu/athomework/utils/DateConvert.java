package com.zhihuishu.athomework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final DateFormat format = new SimpleDateFormat(DEFAULT_PATTERN);

    public static String DateToStr(Date date) {
        if(date == null){
            return null;
        }
        return format.format(date);
    }

    public static Date StrToDate(String str) {
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
