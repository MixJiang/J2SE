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
public class FileStreamTest {

    public static void main(String[] args) throws IOException {

//        //单纯用字符流读不出汉字 编码不一样
        FileReader filein = new FileReader(new File("FileStreamTest.txt"));

        //编码要改成 gb2312 不是 UTF-8
        // 字节流改成字符流 读出汉字
        //BufferedReader filein = new BufferedReader(new InputStreamReader(new FileInputStream("FileStreamTest.txt"), "gb2312"));
        //InputStreamReader filein = new InputStreamReader(new FileInputStream("FileStreamTest.txt"),"gb2312"); //这个也行！

        //    直接用字节流  但是读的时候要这样 System.out.println(new String(b,"gb2312"));
        //      InputStream filein = new FileInputStream(new File("FileStreamTest.txt"));

        FileWriter fileout = new FileWriter(new File("DestiFileStreamTest.txt"));



        int c;
        byte[] b = new byte[102];
        while ((c = filein.read()) != -1) {
            System.out.print((char) c);//汉字也是一种字符
//            System.out.println(new String(b,"gb2312"));
            fileout.write(c);
        }
        System.out.println();
        filein.close();
        fileout.close();
    }
}

/* 字节流
FileInputStream ins = new FileInputStream("FileStreamTest.txt"); //读出来
FileOutputStream outs = new FileOutputStream("DestiFileStreamTest.txt");//写进去

byte[] buffer = new byte[1024];
while((byteread = ins.read(buffer)) != -1){//写到buffer里面去
outs.write(buffer);
}
 */
