package com.book.bookshop.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/*
*订单工具类
*  */
public class OrderUtils {
    private static long orderNum = 0L;
    private static String date;
    /*
    * 生成订单编号
    * */
    public static  synchronized String createOrderNum() {
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        if(date == null || !date.equals(str)){
            date = str;
            orderNum = 0L;
        }
        orderNum++;
        long orderNo = Long.parseLong(date) * 10000;
        orderNo += orderNum;
        return String.valueOf(orderNo);
    }
}
