/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;

/**
 *
 * @author PenGuin
 */

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyThread1 extends Thread{
    Sever s = new Sever();
    Socket socket = new Socket();
     public MyThread1(Socket s1){
         socket = s1;
     }
     public void run(){
        try {
            s.write(socket);
        } catch (IOException ex) {
            Logger.getLogger(MyThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}

class MyThread2 extends Thread{
    Sever s = new Sever();
    Socket socket = new Socket();
     public MyThread2(Socket s1){
         socket = s1;
     }
     public void run(){
        try {
         s.read(socket);
        } catch (IOException ex) {
            Logger.getLogger(MyThread2.class.getName()).log(Level.SEVERE, null, ex);
        }   
  }
}

public class Sever {

    private static final int PORT = 8080;
    public void write(Socket socket) throws IOException{
    try {
                PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);//true指没写一行数据就清空缓存

                BufferedReader localreader = new BufferedReader(new InputStreamReader(System.in));

                String msg = null;

                while ((msg = localreader.readLine()) != null){
                    writer.println(msg);//给客户端传数据
                }
            }
           finally {
            System.out.println("关闭连接");
            socket.close();
        }
    }
    public void read(Socket socket)throws IOException{
        try {
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 
                 BufferedReader localreader = new BufferedReader(new InputStreamReader(System.in));

                while (true){
                    String string = reader.readLine();//没有不停的读，只有有数据过来后才读
                    if (string.equals("end"))break;
                    System.out.println("from Cilent: " + string);
                }
            }
           finally {
            System.out.println("关闭连接");
            socket.close();
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException{

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("服务器启动： " + server);

            try {
                Socket socket = server.accept();//服务器启动监听
                System.out.println("建立连接： " + socket);
                new MyThread1(socket).start();
                new MyThread2(socket).start();
            }
       finally {
            server.close();
        }
    }

}
