/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PenGuin
 */

class MyThread3 extends Thread{
    Client c = new Client();
    Socket socket = new Socket();
     public MyThread3(Socket s1){
         socket = s1;
     }
     public void run(){
        try {
            c.write(socket);
        } catch (IOException ex) {
            Logger.getLogger(MyThread3.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}

class MyThread4 extends Thread{
    Client c = new Client();
    Socket socket = new Socket();
     public MyThread4(Socket s1){
         socket = s1;
     }
     public void run(){
        try {
            c.read(socket);
        } catch (IOException ex) {
            Logger.getLogger(MyThread4.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        } 
}
public class Client {

    private static String serverAddress = "localhost";
    private static int port = 8080;

    public void write(Socket socket) throws IOException{
      try {
                PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);//true指没写一行数据就清空缓存

                BufferedReader localreader = new BufferedReader(new InputStreamReader(System.in));

                String msg = null;

                while ((msg = localreader.readLine()) != null){
                      writer.println(msg);//给服务器传数据
                     if(msg.equals("end")){
                         break;
                      }
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
                    //if (string.equals("end")) break;
                    System.out.println("from Server: " + string);
                }
            }
           finally {
            System.out.println("关闭连接");
            socket.close();
        }
    }
    public static void main(String[] args)  throws IOException {
        Socket socket = new Socket(serverAddress ,port);
        
        System.out.println("socket = " + socket);
        new MyThread3(socket).start();
        new MyThread4(socket).start();

       // socket.close();
    }
}
