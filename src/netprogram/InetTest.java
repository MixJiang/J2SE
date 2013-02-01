/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package netprogram;

import java.net.*;
import java.net.UnknownHostException;

/**
 *
 * @author PenGuin
 */
public class InetTest {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println("InetAddress.getByName(null): " + InetAddress.getByName(null));
        System.out.println("InetAddress.getByName('localhost'): " + InetAddress.getByName("localhost"));
        System.out.println("InetAddress.getByName('127.0.0.1'): " + InetAddress.getByName("127.0.0.1"));
        System.out.println("InetAddress.getLocalHost(): " + InetAddress.getLocalHost());
        
        System.out.println("InetAddress.getAllByName('www.baidu.com'):");
        InetAddress[] inetAddress = InetAddress.getAllByName("www.baidu.com");
        for (int i = 0; i < inetAddress.length; i++) {
            System.out.println(inetAddress[i]);
        }

        System.out.println("");

        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8080);
        System.out.println(inetSocketAddress);
    }
}
