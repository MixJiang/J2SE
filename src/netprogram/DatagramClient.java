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
public class DatagramClient {

    private DatagramSocket socket;

    public DatagramClient() throws IOException {
        socket = new DatagramSocket();//用来发送数据报的
    }

    public void startClient() throws IOException {
        try {
            InetAddress remoteIP = null;

            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in, "gb2312"));
            String msg = null;
            System.out.print("Client:");
            while ((msg = localReader.readLine()) != null) {

                //UDP 这里用的是字节流
                byte[] outputData = msg.getBytes();

                //仅仅通过这个建立连接
                remoteIP = InetAddress.getByName("localhost");
                DatagramPacket Packet = new DatagramPacket(outputData, outputData.length, remoteIP, 8080);//直接通过数据包来找到服务器
                socket.send(Packet);

                if (msg.equals("end")) {
                    break;
                }

                DatagramPacket inputPacket = new DatagramPacket(new byte[1024], 1024);//其实这里用一个DatagramPacket就行
                socket.receive(inputPacket);
                
                System.out.println(new String(inputPacket.getData(),0,inputPacket.getLength()));//没收到数据会一直等
                System.out.print("Client:");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭连接");
        }
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new DatagramClient().startClient();
    }
}
