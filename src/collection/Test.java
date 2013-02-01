/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.awt.Point;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author PenGuin
 */

interface Config{
    int MAX = 10;
    int MIN = 0;
}

class Extend_Class extends Test implements Config{ //一个java里只能有一个 public 类

    final int a = 0;//默认是public的
    private int b;
    protected int c;


    protected int foo() {
        return 1;
    }

    @Override
    public void testFinal() {
    }
}

public /*final*/ class Test {

    private int test = 0;
    public int[] buffer = new int[10];
    protected int t = 0;

    public /*final*/ void testFinal() {
    }


    public void String_test(String str) {
        System.out.println(str);
    }

    static void swapInt(int a, int b){
        int temp;
        temp = a;
        a = b;
        b = temp;
    }
    
    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException, UnsupportedEncodingException, InterruptedException {

//         String a = new String("1");
//         String b = "1";
//         String c = "1";
//         System.out.println(a == b);
//         System.out.println(c == b);
//         
//         int[] intArray1 = new int[]{1,2,3,4};
//         int[] intArray2 = intArray1;
//         
//         intArray2[0] = 2;
//         System.out.println(intArray1[0]);
         
//        Locale l = Locale.getDefault();
//        System.out.println(l.getDisplayLanguage());
//
//        System.out.println(System.getProperty("user.name"));
//        System.out.println(System.getProperty("os.name"));
//
         

//          StringBuffer a = new StringBuffer("123");
//          System.out.println("a.capacity() = " + a.capacity());

//          Integer a = new Integer(0xa);
//          System.out.println(a);
//          System.out.println(a.toString());
//          System.out.println(a.byteValue());
//          //怎么实现的？
//          System.out.println(a.toBinaryString(a));
          

//        other.thread t = other.thread.currentThread();
//        System.out.println(t);
//        t.setName("My other.thread");
//        System.out.println(t);


//        Test a = new Test();
//        a.t = 1;
//        Object b = a;
//        System.out.println(b instanceof Test);
//        Test c = (Test) b;
//        System.out.println(c.t);


        /*
        int a; //默认访问类型完全是public类型
        public int b;
        private int c;
         */

//        //同一包内的类之间的protected类型是可以访问的
//        Collection_Test ct = new Collection_Test();
//        System.out.println(ct.a);
//        System.out.println(ct.b);
//
//        //不同包内
//        Interface_Test it = new Interface_Test();
//        System.out.println(it.b);
//
//
//        Extend_Class ec = new Extend_Class();
//        System.out.println(Extend_Class.MAX);//这个是常量
//        System.out.println(ec.c++);
//
//        int a = 0;
//        System.out.println(a);
//        
//        int b;
//        System.out.println(b);

//        ArrayList testList = new ArrayList();
//
//        for (int i = 0; i < 10; i++) {
//            testList.add(i);
//        }
//
//        Collections.sort(testList, Collections.reverseOrder());
//
//        for (int i = 0; i < testList.size(); i++) {
//            System.out.println(testList.get(i));
//        }
//
//        System.out.println(Collections.max(testList));
        
//        if (System.out.format("Hello ") == null) {
//            System.out.println("Hello ");
//        }else{
//            System.out.println("World");
//        }

        //Set序列是没有顺序的
//        HashSet testSet = new HashSet();
//        for (int i = 10; i > 0; i--) {
//            testSet.add(i);
//        }
//        
//        testSet.add(21);
//        testSet.add(11);
//        testSet.add(31);
//        
//        Iterator iterator = testSet.iterator();
//
//        while (iterator.hasNext()) {
//            Integer a = (Integer) iterator.next();
//            System.out.println(a);
//        }

//        Map testMap = new TreeMap(Collections.reverseOrder());
//        testMap.put(1, "789");
//        testMap.put(4, "456");
//        testMap.put(7, "123");
////
//        Set s = testMap.keySet();
//        Iterator iterator = s.iterator();
////
//        while (iterator.hasNext()) {
//            Integer a = (Integer) iterator.next();
//            System.out.println(a + " " + testMap.get(a));
//        }


//        int i = 0;
//        int j = 0;
//        int mark[] = {5, 4, 3, 2, 1};
//        int other.test[] = new int[5];
//
//        int reslut = Arrays.binarySearch(mark, 0);
//        Arrays.sort(mark, 0, 5);
//        System.out.println(reslut);
//
//        for (int k = 0; k < mark.length; k++) {
//            System.out.print(mark[k] + " ");
//        }
//        System.out.println();
//

//          double d[][] = new double[2][];
//          d[0] = new double[5];
//          d[1] = new double[3];
//
//          System.out.println(d.length);
//          System.out.println(d[0].length);



    }
}
