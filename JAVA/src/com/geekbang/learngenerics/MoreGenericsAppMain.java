package com.geekbang.learngenerics;

import com.geekbang.learngenerics.ext.Children;
import com.geekbang.learngenerics.ext.GrandParent;
import com.geekbang.learngenerics.ext.Parent;

import java.util.ArrayList;
import java.util.List;

public class MoreGenericsAppMain {
    public static void main(String[] args){
        List<Children> g3List = new ArrayList<>();
        // >>TODO 会报错，泛型类型不管继承关系，只管严格的匹配
        // >>TODO 换句话说，Children是Parent的子类，但是List<Children>不是List<Parent>的子类
//        justG2Method(g3List);

        // >>TODO how? 要让接受方，也就是形参，声明为协变参数
        extMethod(g3List);

        List<? extends Parent> g2ListExt = null;
        g2ListExt = new ArrayList<Parent>();
        g2ListExt = new ArrayList<Children>();
//        g2ListExt = new ArrayList<GrandParent>();

        // >>TODO 但是使用这个带协变范围的引用，我们无法让具体的类型满足其参数要求
//        g2ListExt.add(new GrandParent());
//        g2ListExt.add(new Parent());
//        g2ListExt.add(new Children());

        // >>TODO 除了协变，Java还允许逆变，语法如下
        // >>TODO 逆变和协变正好相反，允许的类型为Parent或者其父类
        List<? super Parent> g2ListSup = null;

//        g2ListSup = new ArrayList<Children>();
        g2ListSup = new ArrayList<Parent>();
        g2ListSup = new ArrayList<GrandParent>();

        // >>TODO 无论是协变还是逆变，都只能用在引用上，而不能在创建对象时使用其作为泛型参数
//        List<? extends Parent> g2ListExt11 = new ArrayList<? extends Parent>();
    }

    // >>TODO 协变语法如下，意思就是这个参数可以接受的List引用的范围类型为Parent或者其子类
    public static void extMethod(List<? extends Parent> extParam){

    }
    public static void justG2Method(List<Parent> extParam){

    }
}
