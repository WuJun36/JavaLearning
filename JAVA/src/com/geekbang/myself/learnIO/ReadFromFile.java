package com.geekbang.myself.learnIO;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/13
 * @description：从文件中读取内容
 */
public class ReadFromFile {

    private static final String SOURCE_FILE = "quiet down.txt";

    public static void main(String[] args) throws IOException {
        File sourceFile = new File("." + File.separator + SOURCE_FILE);
        System.out.println(sourceFile.getCanonicalPath());

        readFromFile(sourceFile);
        System.out.println("-------------------coolerWay----------");
        coolerWay(sourceFile);
    }

    private static void readFromFile(File file) {
        try (
                InputStream is = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr);
        ) {
            while (true) {
                String readLine = reader.readLine();
                if (readLine == null) break;
                System.out.println(readLine.trim().toUpperCase());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    private static void coolerWay(File file) {

        try (
                InputStream is = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr);
        ) {
            reader.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
