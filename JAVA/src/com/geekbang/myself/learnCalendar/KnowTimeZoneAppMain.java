package com.geekbang.myself.learnCalendar;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.stream.Stream;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/14
 * @description：运用TimeZone转换时区
 */
public class KnowTimeZoneAppMain {

    public static void main(String[] args) {
        // TODO 获取默认时区
        TimeZone defaultTimeZone = TimeZone.getDefault();
        // TODO 每一个时区都有一个唯一的ID
        ZoneId zoneId = defaultTimeZone.toZoneId();
        String id = defaultTimeZone.getID();
        System.out.println(zoneId);
        System.out.println(id);

        TimeZone tzGMT8 = TimeZone.getTimeZone("GMT+08:00");
        TimeZone tzSeoul = TimeZone.getTimeZone("Asia/Seoul");
        System.out.println("tzGMT8==" + tzGMT8.getID());
        System.out.println("tzSeoul==" + tzSeoul.getID());
//        System.out.println(tzSeoul);
        String[] availableIDs = TimeZone.getAvailableIDs();
        // 采用lambda函数输出，先将数组转换为Stream
//        Stream.of(availableIDs).forEach(System.out::println);

        // TODO 利用Calendar进行时区转换
        // TODO 步骤
        // TODO 1、创建Calendar实例
        Calendar calendar = Calendar.getInstance();
        System.out.println("now=="+calendar.getTime());
        // TODO 2、清除所有字段
        calendar.clear();
        // TODO 3、设置日期和时间
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        calendar.set(2021,0,14,11,33,10);
        SimpleDateFormat sdf = new SimpleDateFormat();
        // TODO 说明：由于Date或者Calendar不能改变时区，所以程序呈现出来的都是当地时间
        // TODO 即如果不进行下面这种设置，程序会自动把calendar存储的韩国时间转成当地时间而打印出来
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println("Asia/Seoul=="+sdf.format(calendar.getTime()));
        // TODO 4、显示时间
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println("Asia/Shanghai=="+sdf.format(calendar.getTime()));



    }
}
