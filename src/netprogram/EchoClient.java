/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netprogram;
import java.io.*;
import java.net.*;
/**
 *da
 * @author PenGuin
 */
public class EchoClient {

 // private static String serverAddress = "localhost";
   private static String serverAddress = "127.0.0.1";
    private static int port = 8080;

    public static void main(String[] args) throws IOException{
        Socket socket = new Socket(serverAddress ,port);

//        socket.setReuseAddress(true);//确保该socket关闭后，其之前绑定对端口和ip马上能用
//        socket.setSendBufferSize(1024);
//        socket.setReceiveBufferSize(1024);
//        socket.setPerformancePreferences(1, 3, 2);//依次代表连接时间，延迟，线路带宽，数值越高重要性越大
        
        try {
            System.out.println("socket = " + socket);

             //TCP 这里用的是字符流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);//true指没写一行数据就清空缓存

            BufferedReader localreader = new BufferedReader(new InputStreamReader(System.in,"gb2312"));//可以输入汉字

            String msg = null;
            System.out.print("Client:");
            while ((msg = localreader.readLine()) != null){
                writer.println(msg);//给服务器传数据
               if(msg.equals("end")){
                   break;
               }
                System.out.println("from Server: " + reader.readLine());
                System.out.print("Client:");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally  {
            System.out.println("关闭连接")
                    ;
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
