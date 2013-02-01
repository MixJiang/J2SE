/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author PenGuin
 */
public class PropertiesDemo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties prop = new Properties();

        prop.setProperty("班长", "小明");
        prop.setProperty("学习委员", "小红");
        prop.setProperty("团支书", "小强");
        prop.setProperty("teacher", "Mr Wang");

//        Set s = prop.keySet();
//
//        Iterator it = s.iterator();
//
//        while (it.hasNext()) {
//            String position = (String) it.next();
//            System.out.println(position + " :" + prop.getProperty(position));
//        }

        FileOutputStream fileOut = new FileOutputStream(new File("dutyList.txt"));
        OutputStreamWriter out = new OutputStreamWriter(fileOut);

        prop.store(out, "Don't edit this file!");
//        prop.storeToXML(out, null, "gb2312");

        Properties loadProp = new Properties();

        FileInputStream in = new FileInputStream(new File("dutyList.txt"));
        loadProp.load(in);

        Set loadSet = prop.keySet();

        Iterator loadIt = loadSet.iterator();

        while (loadIt.hasNext()) {
            String position = (String) loadIt.next();
            System.out.println(position + " :" + prop.getProperty(position));
        }

        String str = "生活委员";
        System.out.println(str + ": " + prop.getProperty(str, "空缺"));



    }
}
