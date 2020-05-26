package com.geekbang.learngenerics;

import java.util.ArrayList;
import java.util.List;

public class UseGenericClassAppMain {
    public static void main(String[] args) {

    }

    private static List createStringList() {
        List ret = new ArrayList();
        for (int i = 0; i < 10; i++) {
            ret.add("str" + i % 5);
        }
        return ret;
    }

    private static void useStringList() {
        List strList = createStringList();
        for (int i = 0; i < strList.size(); i++) {
            String str = (String) strList.get(i);
            str = str.toUpperCase();
            System.out.println(str);
        }
    }

    private static List<String> createStringListGenerics() {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ret.add("str" + i % 5);
        }
        return ret;
    }

    private static void useStringListGenerics() {
        List<String> strList = createStringListGenerics();
        for (int i = 0; i < strList.size(); i++) {
            String str = strList.get(i).toUpperCase();
            System.out.println(str);
        }
    }
}
