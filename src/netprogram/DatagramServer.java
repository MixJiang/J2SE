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
public class DatagramServer {

    private DatagramSocket socket;

    public DatagramServer() throws IOException {
        socket = new DatagramSocket(8080);//这里就初始化了一下端口
        System.out.println("服务器启动……");
    }

    public void startServer() {

        try {
            //UDP 这里用的是字节流

            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            System.out.println("等待接收数据");

//            System.out.println(packet.getSocketAddress());
//            System.out.println(socket.getReceiveBufferSize());
//            System.out.println(socket.getLocalSocketAddress());
//            System.out.println(socket.getSendBufferSize());

            String msg = null;

            while (true) {

                socket.receive(packet);
                msg = new String(packet.getData(), 0, packet.getLength());

                // System.out.println(packet.getSocketAddress());
                if (msg.equals("end")) {
                    break;
                }

                System.out.println("From " + packet.getAddress() + ":" + msg);

                packet.setData(("from Server:" + msg).getBytes());//注意 这里没有指定客户端的IP 默认的就连上了
                socket.send(packet);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭连接");
            socket.close();

        }

    }

    public static void main(String[] args) throws IOException {
        new DatagramServer().startServer();
    }
}
