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
public class ReadMemoryTest {

    public static void main(String[] args) throws IOException {

        //这里的汉字能正确读出来 编码 与ReadMemoryTest.java文件有关
        // BufferedReader inReader = new BufferedReader(new FileReader("ReadMemoryTest.java"));
        //BufferedReader inReader = new BufferedReader(new FileReader("IO_Test_File.txt"));//这里的读不出来，是乱码

        //编码要改成 gb2312 不是 UTF-8
        BufferedReader inReader=new BufferedReader(new InputStreamReader(new FileInputStream("IO_Test_File.txt"),"gb2312"));
        String s1,s2 = new String();//这也行？

        while((s1 = inReader.readLine()) != null){
//            System.out.println(s1);
            s2 += s1 + "\n";
        }

        inReader.close();

        //从内存读的意思是：读取从已存入字符串的数据
        StringReader inReader2 = new StringReader(s2);
        int c;

        while((c = inReader2.read()) != -1){
            System.out.print((char)c);
        }

        inReader2.close();

    }
}
