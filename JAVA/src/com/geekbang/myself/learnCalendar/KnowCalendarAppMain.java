package com.geekbang.myself.learnCalendar;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/14
 * @description：Calendar类常用方法
 */
public class KnowCalendarAppMain {

    public static void main(String[] args) {
        // TODO Calendar类只能通过getInstance()方法来创建实例
        Calendar calendar = Calendar.getInstance();
        // TODO getTime()方法会将Calendar类型转换为Date类型
        Date date = calendar.getTime();
        System.out.println("calendar.getTime()====="+date);
        // TODO 年份无需再加1900，Calendar类只能通过get()方法，传入不同的field类型来获取年月日等信息，
        System.out.println("calendar.get(Calendar.YEAR)===="+calendar.get(Calendar.YEAR));
        //TODO 月份需要加1,程序内月份为0~11
        System.out.println("calendar.get(Calendar.MONTH)===="+calendar.get(Calendar.MONTH)+1);
        System.out.println("calendar.get(Calendar.DATE)===="+calendar.get(Calendar.DATE));
        System.out.println("calendar.get(Calendar.HOUR)===="+calendar.get(Calendar.HOUR));
        System.out.println("calendar.get(Calendar.MINUTE)===="+calendar.get(Calendar.MINUTE));
        System.out.println("calendar.get(Calendar.SECOND)===="+calendar.get(Calendar.SECOND));

        // TODO Calendar也可以自己设置时间
        System.out.println("===================");
        calendar.clear();    //TODO 清除所有
        calendar.set(Calendar.YEAR,2020);
        calendar.set(Calendar.MONTH,11);
        calendar.set(Calendar.DATE,29);
        calendar.set(Calendar.HOUR,11);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        System.out.println("calendar.getTime()====="+calendar.getTime());
        System.out.println("calendar.get(Calendar.YEAR)===="+calendar.get(Calendar.YEAR));
        System.out.println("calendar.get(Calendar.MONTH)===="+(calendar.get(Calendar.MONTH)+1));

        // TODO SimpleDateFormat 自定义输出的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(calendar.getTime()));
        // TODO Calendar可以做时间的加减运算
        calendar.add(Calendar.MONTH,2);
        calendar.add(Calendar.DATE,20);
        System.out.println(sdf.format(calendar.getTime()));

        int actualMaximum = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(actualMaximum);




    }
}
