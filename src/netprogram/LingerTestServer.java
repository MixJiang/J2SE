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

//区别于EchoServer是用对字节流传输对数据

public class LingerTestServer {

    public static void main(String[] args)throws IOException,InterruptedException {

        ServerSocket severSocket = new ServerSocket(8080);
        Socket s = severSocket.accept();
        Thread.sleep(3000);
        InputStream in = s.getInputStream();//没用BufferedReader，因为不是一行一行的从流里面读数据

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();//输出流字节数组
        // byte[] buff = new byte[1];
        byte[] buff = new byte[2];
        int len = -1;
        do {
            len = in.read(buff);//一字节一字节的读
            if (len != -1) {
                buffer.write(buff, 0, len);
                //System.out.println(buffer.toString());
                 System.out.println(new String(buffer.toByteArray()));
           //      System.out.println(new String(buff));
            }
        } while (len != -1);
    }
}
