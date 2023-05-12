package org.project.controller.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class DateUtil {
     public String getCurrentDateTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new java.util.Date());
        /*System.out.println("当前时间："+date);*/
        return date;
    }
}
