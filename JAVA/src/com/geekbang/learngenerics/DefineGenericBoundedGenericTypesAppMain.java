package com.geekbang.learngenerics;

import com.geekbang.learngenerics.define.MyGenericClassBounded;

import java.lang.reflect.Field;

public class DefineGenericBoundedGenericTypesAppMain {
    public static void main(String[] args) throws NoSuchFieldException {
        Field field = MyGenericClassBounded.class.getDeclaredField("myType");
        System.out.println(field.getType());
    }
}
