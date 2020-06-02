package learnthread.learntime;

import com.geekbang.exception.Caller1;
import com.geekbang.learnsocket.SimpleServer;
import sun.awt.geom.AreaOp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class LearnDate {
    public static void main(String[] args) {
        setTimeManually();
        initCalendar();
        operateTime();

    }

    private static void setTimeManually() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.NOVEMBER, 20, 21, 33, 44);
        Date date = calendar.getTime();
        System.out.println(date);

        // TODO SimpleDateFormat 不是线程安全的，对线程共用一个instance会有问题
        // TODO 可以考虑用ThreadLocal给每个工作线程分配一个，也可以每次用到的时候创建实例
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
        System.out.println(sdf.format(date));
    }

    private static void initCalendar() {
        Calendar c2 = Calendar.getInstance();
        c2.setTimeInMillis(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(10));
        c2.setTime(new Date());
        System.out.println(c2.getTime());
    }

    private static void operateTime() {
        // TODO 默认是当前时间
        Calendar calendar = Calendar.getInstance();

        // TODO 使用Calender可以对时间进行加减
        calendar.add(Calendar.DAY_OF_YEAR,100);
        calendar.add(Calendar.MINUTE,100);

        // TODO 可以方便的得到Dated对象
        Date date = calendar.getTime();
        System.out.println(date);
    }
}
