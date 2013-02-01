/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iostream;
import java.io.*;
/**
 *
 * @author PenGuin
 */
public class Redirecting {

    public static void main(String[] args) throws IOException{
        
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("Redirecting.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.txt")));

        System.setIn(in);//重定向输入
        System.setOut(out);//out也被重定向了 所以终端显示不出来

        BufferedReader breader = new BufferedReader(new InputStreamReader(System.in,"gb2312"));

        String s;

        while((s = breader.readLine()) != null && s.length() != 0){//手动输入
            System.out.println(s);
        }

        //另一种方法
//        int c;
//        byte[] buffer = new byte[1024];
//
//        while((c = in.read(buffer)) != -1){//手动输入
//
//            System.out.println(new String(buffer,"gb2312"));
//        }
        
        out.close();

    }
}
