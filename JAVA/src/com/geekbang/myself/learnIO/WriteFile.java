package com.geekbang.myself.learnIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/12
 * @description：创建文件，并写入数据
 */
public class WriteFile {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String root = ".";
        String s = inputDirs(root);
        File dir = createDirs(s);
        File file = createFile(dir);
        writeToFile(file);

//      writeFile(writer);


    }


    private static String inputDirs(String root) {
        String dir = root;
        while (true) {
            System.out.println("请输入目录名称");
            String str = in.nextLine();
            if (str == null || str.isEmpty()) {
                break;
            }
            dir = dir + File.separator + str;

        }
        return dir;
    }

    private static File createDirs(String path) throws IOException {
        if (path != null && !path.isEmpty()) {
            File file = new File(path);
            if (file.isDirectory()) {
                System.out.println("文件目录已存在");
            } else {
                if (file.mkdirs()) {
                    System.out.println(file.getName() + "目录创建成功");
                    return file;
                } else {
                    throw new IOException("文件目录创建失败");
                }
            }
        }
        return null;
    }

    private static File createFile(File parentFile) {
        System.out.println("请输入文件名");
        String fileName = in.nextLine();
        File file = new File(parentFile, fileName + ".txt");
        if (file.isFile()) {
            System.out.println("文件已存在");
        } else {
            try {
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                System.out.println("文件创建失败");
                e.printStackTrace();
            }
        }

        return file;
    }

    private static void writeFile(PrintWriter writer) {

        while (true) {
            System.out.println("请输入内容：");
            String content = in.nextLine();
            if (content == null || content.isEmpty()) break;
            writer.println(content);
            writer.flush();
        }

        System.out.println("输入完成");

    }


    private static void writeToFile(File targetFile) {
        try (
                // TODO 创建FileOutputStream，建立从程序到文件的字节流
                OutputStream os = new FileOutputStream(targetFile);
                // TODO 建立一个可以消费OutputStream的OutputStreamWriter，并指定字符集，这样就可以一个个写入字符
                // TODO OutputStreamWriter接受字符，并将字符转换为字节，输出给OutputStream
                OutputStreamWriter osWriter = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                // TODO PrintWriter 可以写入一行字符串，这是一种缓冲字符输出流
                PrintWriter writer = new PrintWriter(osWriter)) {

            System.out.println("输入的内容会实时写入文件，如果输入空行则结束");
            while (true) {
                String lineToWrite = in.nextLine().trim();
                System.out.println("写入的内容为：" + lineToWrite);
                if (lineToWrite.trim().isEmpty()) {
                    System.out.println("输入结束！");
                    break;
                }
                writer.println(lineToWrite);
                writer.flush();   //TODO 刷新缓冲区，即将缓冲区的数据写入文件
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

}
