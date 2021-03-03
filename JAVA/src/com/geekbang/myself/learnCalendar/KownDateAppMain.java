package com.geekbang.myself.learnCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/13
 * @description：Date类型是java8之前的API
 */
public class KownDateAppMain {

    public static void main(String[] args) {
        // TODO Date类型不能做时区的转换，Date类型会根据当前所在区域自动显示为当地时间
        Date date = new Date();   //TODO 返回的是当地时间
        Date date1 = new Date(1000);   // TODO 传入long类型， 表明距离标准时间的毫秒数（1970年，伦敦时间0点）
        Date date2 = new Date(2021,1,14);
        System.out.println(date);
        System.out.println(date1);
        System.out.println(date2);


        System.out.println(date.getYear()+1900);   // TODO 必须要加上1900
        System.out.println(date.getMonth() + 1);  // TODO getMonth()返回的是0~11
        System.out.println(date.getDate());  // TODO getDate()返回的是1~31

        System.out.println(date.toString());
        System.out.println(date.toGMTString());
        System.out.println(date.toLocaleString());   //本地时间格式

        // TODO SimpleDateFormat 自定义日期输出的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MMM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
        System.out.println(date.getTime());
    }
}
