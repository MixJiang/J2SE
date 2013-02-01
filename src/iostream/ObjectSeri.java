/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iostream;
import java.io.*;
import java.util.Date;
/**
 *
 * @author PenGuin
 */
//和 FilterIOTest.java里面的情况有点像，那里面逐个写入的是基本数据类型
public class ObjectSeri {

    public static void main(String[] args) {
        try {
//            FileOutputStream out = new FileOutputStream("ObjectSeri.txt");
//            ObjectOutputStream sOut = new ObjectOutputStream(out);
//
//            sOut.writeObject(new String("current time is: "));
//            sOut.writeObject(new Date());
//            sOut.writeInt(1000);
//
//            sOut.flush();
//            out.close();

            FileInputStream in = new FileInputStream("ObjectSeri.txt");
            ObjectInputStream sIn = new ObjectInputStream(in);

            String flag = (String)sIn.readObject();
            Date date = (Date)sIn.readObject();
            int i = (int)sIn.readInt();

            System.out.println(flag + date);
            System.out.println("int型数据: " + i);

            in.close();
        } catch (IOException e) {
            System.out.println("IOException happened");
        }catch (ClassNotFoundException e){
            System.out.println("ClassNotFoundException happened");
        }
    }
}
