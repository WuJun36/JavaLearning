package com.geekbang.myself.learnIO;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/12
 * @description：操作File类，创建文件，对文件重命名等
 */
public class UseFileAppMain {

    private static String ROOT = "C:\\Users\\wujun\\Desktop\\test";
    private static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        // TODO 使用File类，依次创建多层文件夹，修改文件夹名字，在指定文件夹创建文件，删除文件，删除文件夹
        File dirFile = new File(ROOT);
        while (true) {
            System.out.println("请输入要创建的文件夹名称,输入回车符结束");
            String dirName = in.next();
            if (dirName.trim().isEmpty()) {
                break;
            }
            dirFile = new File(dirFile, dirName);
            dirFile.mkdir();
        }

        System.out.println("输入要创建的文件名称");
        String fileName = in.next();
        createFile(dirFile, fileName);

    }


    public static void deleteDir(File file) {

    }

    public static void createFile(File parentFile, String fileName) {
        for (int i = 0; i < 10; i++) {
            File file = new File(parentFile, fileName + i + ".txt");
            System.out.println("创建了文件：" + fileName + i + ".txt");
        }

    }

}
