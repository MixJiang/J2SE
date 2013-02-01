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
public class SimpleClient {

    static Socket server;

    public static void main(String[] args) throws Exception {
        //server = new Socket(InetAddress.getLocalHost(),8080);
        // server = new Socket(InetAddress.getByName(null),8080);
        server = new Socket("localhost", 8080);

        System.out.println("建立Socet链接……");

        System.out.println("本服务端口: " + server.getLocalPort());
        System.out.println("服务器端口: " + server.getPort());
        System.out.println("本地地址信息: " + server.getLocalAddress());
        System.out.println("服务器对象信息： " + server.getInetAddress());
        System.out.println("服务器IP地址: " + (server.getInetAddress()).getHostAddress());
        System.out.println("服务器主机名: " + (server.getInetAddress()).getHostName());

        BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));

        PrintWriter writer = new PrintWriter(server.getOutputStream(), true);//true指没写一行数据就清空缓存

        BufferedReader localreader = new BufferedReader(new InputStreamReader(System.in,"gb2312"));

        String msg = null;
        while ((msg = localreader.readLine()) != null) {//不写数据就会停在这儿 相当于 cin >> string;
            writer.println(msg);
            if (msg.equals("end")) {
                break;
            }
            System.out.println("from Server: " + reader.readLine());
        }
        server.close();
    }
}
