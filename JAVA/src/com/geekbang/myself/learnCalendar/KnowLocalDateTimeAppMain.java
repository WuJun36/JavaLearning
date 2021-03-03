package com.geekbang.myself.learnCalendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/14
 * @description：
 */
public class KnowLocalDateTimeAppMain {

    public static void main(String[] args) {
        // 没有对外提供构造函数
//        LocalDateTime localDateTime = new LocalDateTime();
        // TODO 调用now()方法获取到本地时区的当前时间，并按照ISO 8601标准返回
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println(dateTime);
        System.out.println(date);
        System.out.println(time);
        int year = dateTime.getYear();
        Month month = dateTime.getMonth();
        int monthValue = dateTime.getMonthValue();     // TODO 月份是1~12
        int dayOfMonth = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();
        System.out.println(year + "-" + monthValue + "-" + dayOfMonth + " " + hour + ":" + minute + ":" + second);
        System.out.println("-----------------");

        // TODO 通过of函数指定具体的日期
        LocalDateTime localDateTime1 = LocalDateTime.of(2020,10,10,6,34,23);
        LocalDate localDate1 =  LocalDate.of(2021,1,11);
        LocalTime localTime1 = LocalTime.of(23,12,11);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate1,localTime1);
        System.out.println(localDateTime1);
        System.out.println(localDateTime1.toLocalDate());
        System.out.println(localDateTime1.toLocalTime());
        System.out.println("----------------");
        System.out.println(localDate1);
        System.out.println(localTime1);
        System.out.println(localDateTime2);

        // TODO 也可以通过parse()方法解析字符串为日期时间，字符串需要符合ISO 8601的标准格式
        System.out.println("-----------------");
        LocalDateTime localDateTime3 = LocalDateTime.parse("2021-02-01T12:00:01");
        LocalDate localDate3 = LocalDate.parse("2020-12-09");
        LocalTime localTime3 = LocalTime.parse("12:09:12");
        System.out.println(localDateTime3);
        System.out.println(localDate3);
        System.out.println(localTime3);
        // TODO 也可以在解析时传入自定义的格式，字符串符合自定义的格式也可以成功解析
        System.out.println(LocalDateTime.parse("2021-02-01 12:20:01",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // TODO 对时间进行加减运算
        System.out.println(localDateTime3.plusMonths(1).minusDays(10));

        // 打印昨天的当前时刻
        System.out.println(LocalDateTime.now().minusDays(1));



    }
}
