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
public class Test_In_All {

    public static void main(String[] args) throws IOException{
        FileOutputStream fileStream = new FileOutputStream("Test_In_All_src.txt");

        File myFile_scr = new File("Test_In_All_scr.txt");
        FileWriter filewriter = new FileWriter(myFile_scr);
        PrintWriter printwriter = new PrintWriter(filewriter);

        File myFile_des = new File("Test_In_All_scr.txt");
        FileReader filereader = new FileReader(myFile_des);
        BufferedReader bufferedreader = new BufferedReader(filereader);

        double[] prices = {11,22,21,41,23,8,9,10,29,12};
        int[] counts = {1,2,3,4,5,6,7,9,3,4};
        String[] descs = {"Java T-shirt", "JavaDoc", "Java pin", "Java App", "Hello", "Javac", "applet", "Java jar" ,"JDK","World"};

        for (int i = 0; i < descs.length; i++) {
           // fileStream.write(counts[i]);
              printwriter.println(counts[i]); //隔行写
           //   printwriter.write(descs[i]);     //一个一个接着写
        }

        String c;
        byte[] buffer = new byte[20];
        for (int i = 0; i < descs.length; i++) {
             c = bufferedreader.readLine();
             System.out.println(c);
        }

        filewriter.close();//没关文件就直接写不进去


    }
}
