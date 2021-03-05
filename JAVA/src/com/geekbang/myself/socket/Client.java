package com.geekbang.myself.socket;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author ：wujun
 * @date ：Created in 2021/3/5
 * @description：TCP编程-客户端
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6666);
        try (InputStream inputStream = socket.getInputStream()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                handle(outputStream, inputStream);
            }
        }
        socket.close();
        System.out.println("disconnected");

    }

    private static void handle(OutputStream os, InputStream is) throws IOException {
        System.out.println("handle");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
//        String ss = reader.readLine();
//        System.out.println("[server] " + ss);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">>");
            String s = scanner.nextLine();
            writer.println(s);
            writer.flush();
            String resp = reader.readLine();

            System.out.print("<<" + resp);
            System.out.println();
            if ("bye".equals(resp)){
                break;
            }

        }
    }
}
