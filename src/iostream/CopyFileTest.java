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
public class CopyFileTest {

    public void copyFile(String oldFile, String newFile) {
        long startTime = System.currentTimeMillis();//测过读文件的速度
        try {
            int bytesum = 0;
            int byteread = 0;

            //嵌套这个类的意思是要 执行oldfile.exists()语句，不然就没必要
            File oldfile = new File(oldFile);


            //通过ins.read() 和 outs.write（）来进行文件之间的读写
            if (oldfile.exists()) {
                //我怎么感觉搞反了啊
                FileInputStream ins = new FileInputStream(oldFile); //读出来
                FileOutputStream outs = new FileOutputStream(newFile);//写进去

                byte[] buffer = new byte[1024];

                while ((byteread = ins.read(buffer)) != -1) {//写到buffer里面去
                    bytesum += byteread;
                    System.out.println(bytesum);

//                System.out.println(buffer.toString()); //这个不行 必须 new String(buffer)

//                String s = new String(buffer,"gb2312"); //默认编码问题
//                System.out.println(s);

                    outs.write(buffer, 0, byteread);//能写进去，汉字读到终端是乱码
                }
                ins.close();
            }
        } catch (Exception e) {
            System.out.println("原文件不存在");
            e.printStackTrace();
        }
        long totalTime = System.currentTimeMillis() - startTime;

        System.out.println(totalTime);
    }

    public static void main(String[] args) {
        CopyFileTest copyfile = new CopyFileTest();
        copyfile.copyFile("copyfile1.txt", "copyfile2.txt");
    }
}
