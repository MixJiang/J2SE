/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.io.*;

/**
 *
 * @author PenGuin
 */
public class ExceptionTest {

    public static void main(String[] args) {
        String s1 = new String();
        String s2 = new String();

        try {
            BufferedReader in = new BufferedReader(new FileReader("ExceptionTest.java"));

            while ((s1 = in.readLine()) != null) {
                s2 += s1 + "\n";
            }

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //注意这里的StringReader,上面读文件是用的FileWriter
            BufferedReader in2 = new BufferedReader(new StringReader(s2));
            PrintWriter printout = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));

            int linecounter = 1;

            while ((s1 = in2.readLine()) != null) {
                printout.println(linecounter++ + " " + s1);
            }

            printout.close();
            in2.close();

        } catch (EOFException e) {
            System.err.println("文件保存完毕，新文件名为out.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
