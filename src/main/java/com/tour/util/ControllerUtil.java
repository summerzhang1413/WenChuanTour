package com.tour.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerUtil {

    public static String getCurrentDate(){
        String formatString = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        return format;
    }


}
