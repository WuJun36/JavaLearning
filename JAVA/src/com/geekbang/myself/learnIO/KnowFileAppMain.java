package com.geekbang.myself.learnIO;


import java.io.File;
import java.io.IOException;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/12
 * @description：了解File类的基本用法
 */
public class KnowFileAppMain {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\");   //TODO "."表示上一层路径
        System.out.println(file.getPath());   //TODO 获取相对路径
        System.out.println(file.getAbsolutePath());      //TODO 获取绝对路径
        System.out.println(file.getCanonicalPath());     //TODO 获取规范路径（规范路径就是把.和..转换成标准的绝对路径后的路径）
        System.out.println(File.separator);   //TODO 当前系统使用的文件分隔符，Windows所使用的文件分隔符为\;Linux使用的文件分隔符为/


        // TODO 创建File对象时，并不会对磁盘文件进行操作，只有执行File的某些方法才会操作磁盘。
        // TODO 因此创建File对象时，如果传入的文件或目录不存在，程序也不会抛出异常
        // TODO file调用exists()方法，判断文件或目录是否存在
        System.out.println(file.exists());
        // TODO file调用isDirectory(),判断是否为已存在的目录
        System.out.println(file.isDirectory());
        // TODO file调用isFile(),判断是否为已存在的文件
        System.out.println(file.isFile());


        File rootFile = new File("C:\\Users\\wujun\\Desktop\\test");
        File[] files = rootFile.listFiles();     // TODO 返回当前目录下所有文件或文件夹
        String[] fileNames = rootFile.list();    // TODO 返回当前目录下所有文件或文件夹的名称
        int i = 0;
        for (String fileName : fileNames) {
            System.out.println(files[i++]);
            System.out.println(fileName);
        }

        File file1 = new File("C:\\Users\\wujun\\Desktop\\test\\createNewFile");
        if(file1.createNewFile()){           // TODO 如果File对象的路径当前不存在文件或者目录，createNewFile()则可以创建成功；否则创建失败
            System.out.println(file1.getName() + " 文件创建成功");
            if (file1.delete()){
                System.out.println(file1.getName() + "文件删除成功");
            }
        }
        File file2 = new File("C:\\Users\\wujun\\Desktop\\test\\createNewDir");
        if (file2.mkdir()){      // TODO 如果当前目录或文件已存在，则不会再创建，否则创建新目录
            System.out.println(file2.getName() + " 目录创建成功");
            if (file2.delete()){
                System.out.println(file2.getName() + " 目录删除成功");
            }
        }
        File file3 = new File("C:\\Users\\wujun\\Desktop\\test\\haha\\createNewDirs");
        if (file3.mkdirs()){      // TODO 如果当前目录或文件已存在，则不会再创建，否则创建新目录，且会根据需要自动补全缺少的上级目录
            System.out.println(file3.getName() + " 目录创建成功");
            if (file3.delete()){
                System.out.println(file3.getName() + "目录删除成功");
            }
        }


        printFiles(rootFile);

    }


    public static void printFiles(File file){
        printFiles(file,0);
    }


    private static void printFiles(File parentFile, int level) {
        String blank = "";
        for (int i = 0; i < level; i++) {
            blank += " ";
        }
        if (parentFile != null) {
            for (File file : parentFile.listFiles()) {
                String fileName = blank + file.getName();
                if (file.isDirectory()) fileName += "/";
                System.out.println(fileName);
                if (file.listFiles() != null) {
                    printFiles(file, level + 1);
                }
            }
        }
    }
}
