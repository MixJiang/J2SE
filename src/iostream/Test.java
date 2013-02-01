/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iostream;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 *
 * @author PenGuin
 */
public class Test {

    public static String getText(String path) throws Exception {
        FileInputStream in = new FileInputStream(path);
        byte[] bit = new byte[in.available()];
        in.read(bit);
        in.close();
        return (new String(bit, "gb2312"));
    }

    //测试函数
    public static void main(String[] a) throws Exception {
        //从磁盘读取文本文件并打印
//        System.out.println("当前JRE：" + System.getProperty("java.version"));
//        System.out.println("当前JVM的默认字符集：" + Charset.defaultCharset());
//
//        String str = Test.getText("IO_Test_File.txt");
//        System.out.println(str);

        String encoding = "gb2312";
        InputStreamReader reader = new InputStreamReader(new FileInputStream(
                "IO_Test_File.txt"), encoding);
        char c[] = new char[100];
        int length = reader.read(c);
        for (int i = 0; i < length; i++) {
            System.out.print(c[i]);
        }
    }
}
