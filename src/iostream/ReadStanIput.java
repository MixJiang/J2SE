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
public class ReadStanIput {

    public static void main(String[] args) throws IOException{

        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//这个不能输入汉字,是乱码
        //InputStreamReader其实就是个转化中介 里面可以放 System.in 或者 FileInputStream
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in,"gb2312"));
        //BufferedInputStream in = new BufferedInputStream(System.in); //读出来

        //这个返回的是整数 还是ASKII 码
//       char a = (char) System.in.read(); //你输入的系统看成是char型
//       System.out.println(a);
//       System.out.println(System.in.read());

        String s = null;

        while((s = in.readLine()) != null && s.length() != 0){
            System.out.println("输出: " + s);

//              用这种方法来读入数据 这里必须是整型的
//            int a = Integer.parseInt(s);
//            System.out.println(a);

        }
    }
}
