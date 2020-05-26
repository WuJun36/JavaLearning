package com.geekbang.learngenerics.define;

import com.geekbang.learngenerics.ext.GrandParent;

public class MyGenericClassBounded<MyType extends GrandParent>{

    // >>TODO 实际上这个引用是GrandParent类型
    private MyType myType;

    public MyGenericClassBounded(MyType myType){
        // >>TODO 所以可以调用GrandParent方法
        myType.getNum();
        this.myType = myType;
    }

    public void setMyType(MyType myType){
        this.myType = myType;
    }
}
