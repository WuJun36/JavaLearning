package com.geekbang.learnString;

public class LearnString {
    public static void main(String[] args) {
        String content = "Orange_Apple_Banana";

        char[] chars = content.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        String sp = "_";
        String[] s = content.split(sp);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        int indexOf = content.indexOf('_');
        System.out.println(indexOf);
        System.out.println(content.substring(indexOf+1,content.length()));

        int lastIndexOf = content.lastIndexOf('_');
        System.out.println(lastIndexOf);
        System.out.println(content.substring(0,lastIndexOf));

        System.out.println(content.contains("Orange"));
        System.out.println(content.contains("orange"));

        String content2 = "Orange_Apple_Banana";
        String content3 = "   orange_Apple_banana   ";

        System.out.println("比较");
        System.out.println(content.equals(content2));
        System.out.println(content == content2);
        System.out.println(content.equals(content3));
        System.out.println(content.equalsIgnoreCase(content3.trim()));

    }

}
