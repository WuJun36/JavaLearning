package com.geekbang.myself.learnCollection;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.util.*;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/15
 * @description：练习Map的使用
 */
public class PractiseMapAppMain {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("Bob", 78), new Student("Alice", 85), new Student("Brush", 66),
                new Student("Newton", 99));
        Students holder = new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");

        // Map.Entry代表Map中的每一个键值对
        for (Map.Entry<String, Integer> entry : holder.cache.entrySet()) {
            System.out.println(entry.getKey() + "的成绩为：" + entry.getValue().intValue());
        }
        System.out.println("----------------------------------");
        // 也可以循环keySet()
        for (String key : holder.cache.keySet()) {
            System.out.println(key + "的成绩为：" + holder.cache.get(key));
        }
        System.out.println("----------------");
        System.out.println("Tom是否在缓存中：" + holder.cache.containsKey("Tom"));
        System.out.println("Bob是否在缓存中：" + holder.cache.containsKey("Bob"));

        System.out.println("xy".equals(null));

        // EnumMap
        System.out.println("-------------EnumMap--------------");
        EnumMap<DayOfWeek,String> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.FRIDAY,"星期一");
    }
}

class Students {
    List<Student> list;
    Map<String, Integer> cache;

    Students(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    int getScore(String name) {
        // 先在Map中查找:
        Integer score = this.cache.get(name);
        if (score == null) {
            // TODO:
            // Map中没有则在List中找
            score = findInList(name);
            // 并将找到的结果放入cache中
            if (score != null) cache.put(name, score);
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (Student ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
