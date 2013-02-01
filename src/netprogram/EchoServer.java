/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package netprogram;

import java.io.*;
import java.net.*;

/**
 *
 * @author PenGuin
 */
public class EchoServer {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(PORT);//如果没有指定端口则操作系统会随机分配
        System.out.println("服务器启动： " + server);

        try {
            Socket socket = server.accept();//服务器启动监听
            //   socket.setSoTimeout(5000);//5秒钟没接到数据则抛出异常
            try {
                System.out.println("建立连接： " + socket);

                //TCP 这里用的是字符流
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//InputStreamReader应该是转化作用
                // PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"gb2312")), true);
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);//true指每写一行数据就清空缓存，很重要
                //PrintWriter writer = new PrintWriter(socket.getOutputStream()); 这样不行
                String msg = null;
                while ((msg = reader.readLine()) != null) {//没有不停的读，只有有数据从socket中过来后才
                    //读,没有读到数据会停住，服务器端敲入的数据暂时放入缓冲区
                    if (msg.equals("end")) {
                        break;
                    }
                    System.out.println("from Client: " + msg);
                    writer.println(msg);//给客户端传数据
                    /*
                    //推迟5秒再输出
                    try {
                    Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    System.out.println("没睡成");
                    }*/
                    //  string = localreader.readLine();

                }
            } finally {//注意这里的finally的使用
                System.out.println("关闭连接");
                socket.close();
            }
        } finally {
            server.close();
        }
    }
}
