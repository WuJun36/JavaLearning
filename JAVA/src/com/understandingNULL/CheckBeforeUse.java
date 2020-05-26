package com.understandingNULL;

import com.understandingArrayClass.Merchandise;

public class CheckBeforeUse {
    // 数组在创建出来后，会按照类型给数组中每个元素赋缺省值
    // 引用类型的缺省值是null
    public static void main(String[] args) {
        Merchandise[] merchandises = new Merchandise[9];
        // 为索引为偶数的引用赋值
        for (int i = 0; i < merchandises.length; i++) {
            if (i % 2 == 0) {
                merchandises[i] = new Merchandise();
            }
        }

        for (int i = 0; i < merchandises.length; i++) {
            if (merchandises[i] != null) {
                merchandises[i].name = "商品" + i;
            }
        }

        for(int i = 0; i <merchandises.length;i++){
            if(merchandises[i] != null){
                System.out.println(merchandises[i].name);
            }
        }
    }


}
