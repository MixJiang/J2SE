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
public class LinkedFileTest {

    private InputStream firstin;
    private InputStream secondin;

    private void getInputStream(String fileone, String filetwo){
        try {
            firstin = new FileInputStream(fileone);
            secondin = new FileInputStream(filetwo);
        } catch (Exception e) {
            System.out.println("参数未初始化");
            e.printStackTrace();
        }
    }
    private void linkFile(){
        try {
            SequenceInputStream s = new SequenceInputStream(firstin,secondin);

            int c;
            byte[] buffer = new byte[80];//改成1或3 就不行了 越大越好 汉字是两个字节
            while((c = s.read(buffer)) != -1){//怎么空格的就读不了了
               // String s = new String(c,"gb2312");
                String s1 = new String(buffer,"gb2312");
                System.out.print(s1);
            }
            s.close();
        } catch (Exception e) {
            System.out.println("输入异常");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
       LinkedFileTest lftest = new LinkedFileTest();
       lftest.getInputStream("IO_Test_File.txt", "FileStreamTest.txt");
       lftest.linkFile();
    }
}
