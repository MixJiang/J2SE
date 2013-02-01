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
public class LingerTestClient {

    public static void main(String[] args)throws IOException, InterruptedException {//InterruptedException  是针对sleep的 与线程有关
        Socket s = new Socket("localhost",8080);
        
       // s.setSoLinger(true, 0); //这种情况就显示不出来,默认是可以显示出来对
      //  s.setSoLinger(true, 1);

        System.out.println(s.getSoLinger()); //关闭后任然传数据的时间
        System.out.println(s.getTcpNoDelay());//是否启用缓冲池
        System.out.println(s.getReuseAddress());//确保该socket关闭后，其之前绑定对端口和ip马上能用
        System.out.println(s.getSoTimeout());//服务器多久没收到信息则抛出异常

        OutputStream out = s.getOutputStream(); 

     //   StringBuffer sb = new StringBuffer();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 30; i++) {
            sb.append(i);
           // Thread.sleep(1000);
        }
        out.write(sb.toString().getBytes());//一字节一一字节的写进流里："123" 就拆成了 ‘1’ ‘2’‘3’ ；sb.toString()还不让写
        System.out.println("starting close socket");
        long begin = System.currentTimeMillis();
        s.close();
        long end = System.currentTimeMillis();
        System.out.println("关闭socket所用时间为："+ (end - begin) + "毫秒");
    }
}
