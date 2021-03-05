package com.geekbang.myself.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author ：wujun
 * @date ：Created in 2021/3/5
 * @description：TCP编程-服务端
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);

        for (; ; ) {

            Socket socket = serverSocket.accept();
            System.out.println("connected from:" + socket.getRemoteSocketAddress());
            Thread t = new Handler(socket);
            t.start();
        }
    }


}

class Handler extends Thread {
    Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        // 资源使用完毕后可自动关闭
        try (InputStream is = this.socket.getInputStream()) {
            try (OutputStream os = this.socket.getOutputStream()) {
                this.handle(is, os);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("client disconnected......");
        }

    }

    private void handle(InputStream is, OutputStream os) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
        writer.print("hello");
        writer.flush();
        while (true) {
            String line = reader.readLine();
            System.out.println("[client]"+line);
            if ("bye".equals(line)) {
                writer.print("bye");
                writer.flush();
                break;
            }
            writer.print("ok:" + line + "\n");
            writer.flush();
        }

    }
}
