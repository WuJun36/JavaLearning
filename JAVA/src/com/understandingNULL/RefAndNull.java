package com.understandingNULL;

import com.understandingArrayClass.Merchandise;

public class RefAndNull {
    public static void main(String[] args) {
        Merchandise[] merchandise = new Merchandise[9];

        for (int i = 0; i < merchandise.length; i++) {
            if (i % 2 == 0) {
                merchandise[i] = new Merchandise();
            }
        }

        for(int i = 0; i < merchandise.length; i++){
            System.out.println(merchandise[i]);
        }

        for (int i = 0; i< merchandise.length;i++){
            if(i%2 == 0){
                Merchandise m = merchandise[i];
                System.out.println(m.price);
                System.out.println(m.count);
                System.out.println(m.name);
                System.out.println(m.id);
            }
        }
    }
}
