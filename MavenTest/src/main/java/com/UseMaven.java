package com;

import com.google.common.base.Splitter;

public class UseMaven {
    public static void main(String[] args) {
        String line = "  This is a     字符串    ";
        Iterable<String> words = Splitter.on(' ').trimResults().omitEmptyStrings().split(line);
        for (String word : words) {
            System.out.println(word);
        }
    }
}
