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
public class RandomAccessTest {

    public static void main(String[] args) throws IOException{
        RandomAccessFile rf = new RandomAccessFile("randomfile.dat","rw");
        for (int i = 0; i < 10; i++) {
            rf.writeDouble(i * 1.414);
        }
        rf.close();//另外再申请一个

        rf = new RandomAccessFile("randomfile.dat","rw");
        rf.seek(5 * 8);//找到目标位置
        rf.writeDouble(47.999991);

        rf.close();

        rf = new RandomAccessFile("randomfile.dat","r");
        for (int i = 0; i < 10; i++) {
            System.out.println("Valeu" + i + ":" + rf.readDouble());//每读一个自动向下走
        }

        rf.close();
    }
}
