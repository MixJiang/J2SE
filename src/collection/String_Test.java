/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package collection;
import java.text.*;

/**
 *
 * @author PenGuin
 */
public class String_Test {
    public static void main(String[] args) {
    	
        String s1 = new String("Hello");
        String s2 = new String("World");
        String s3 = " ";
        char test[] = {'1','2','3','4','5'};
        
        s3 = s1.concat(s2);
        System.out.println(s3);
        s3 = String.copyValueOf(test);//静态方法
        System.out.println(s3);

        //格式化字符串
        SimpleDateFormat formatter = new SimpleDateFormat("今天是"+"yyyy年MM月dd日  E kk点mm分");
        java.util.Date date = new java.util.Date();
        s3 = formatter.format(date);
        System.out.println(s3);
    }

}
