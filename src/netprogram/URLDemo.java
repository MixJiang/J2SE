/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 *
 * @author PenGuin
 */
public class URLDemo {
    public static void main(String[] args) throws MalformedURLException, IOException {
        
        String website = "http://hi.baidu.com/ooer/blog/item/0196ddc4648180db38db4907.html";
//        String website = "http://www.baidu.com";
        URL hp = new URL(website);
//        System.out.println("url.getFile() :" + hp.getFile());
//        System.out.println("url.getProtocol() :" + hp.getProtocol());
//        System.out.println("url.getHost() :" + hp.getHost());
//        System.out.println("url.getPort() :" + hp.getPort());
//        System.out.println(" url.toExternalForm() :" + hp.toExternalForm());

        URLConnection hpCon = hp.openConnection();
        System.out.println("Date: " + new Date(hpCon.getDate()));
        System.out.println("Content-Type: " + hpCon.getContentType());
        System.out.println("Expires: " + hpCon.getExpiration());
        System.out.println("last-Modify: " + hpCon.getLastModified());

        int len = hpCon.getContentLength();
        System.out.println("Content-length:" + len);

        System.out.println("===Content===");
        BufferedReader reader = new BufferedReader(new InputStreamReader(hpCon.getInputStream(),"UTF-8"));
        InputStream in = hpCon.getInputStream();

        int c = 0;
        byte[] b = new byte[1024];
        while ((c = in.read(b)) != -1) {
//            System.out.print((char)c);
            System.out.println(new String(b,"gb2312"));
        }
        reader.close();
        
        System.out.println();
        System.out.println("No Content Available!");

    }
}
