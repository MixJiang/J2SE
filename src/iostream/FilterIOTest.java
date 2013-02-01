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

//Excle 里面应该存的是二进制
public class FilterIOTest {
    public static void main(String[] args) throws IOException {
        DataOutputStream filterout = new DataOutputStream(new FileOutputStream("Filterout.xls"));

        double[] prices = {11,22,21,41,23,8,9,10,29,12};
        int[] counts = {1,2,3,4,5,6,7,9,3,4};
        String[] descs = {"Java T-shirt", "JavaDoc", "Java pin", "Java App", "Hello", "Javac", "applet", "Java jar" ,"JDK","World"};

        for (int i = 0; i < prices.length; i++) {
            filterout.writeDouble(prices[i]);
            filterout.writeChar('\t');
            filterout.writeInt(counts[i]);
            filterout.writeChar('\t');
            filterout.writeChars(descs[i]);
            filterout.writeChar('\n');//这个很重要啊
        }

        filterout.close();

        DataInputStream in = new DataInputStream(new FileInputStream("Filterout.xls"));

        double price;
        int unit;
        StringBuffer desc;
        double total = 0.0;

        try {
            while(true){//这里靠catch来结束while循环
                price = in.readDouble();
                in.readChar();
                unit = in.readInt();
                in.readChar();
                char chr;
                desc = new StringBuffer(20);
            while((chr = in.readChar()) != '\n'){
                desc.append(chr);
              //  System.out.println(desc);
            }
                System.out.println("您定制了" + unit + "个" + desc + "单价是" + price + "$");
                total = total + unit * price;
            }
        } catch (Exception e) {
            in.close();
            System.out.println("总价是 : "+ total);
        }
    }
}
