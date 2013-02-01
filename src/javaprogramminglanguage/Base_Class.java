/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprogramminglanguage;

import java.awt.Point;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author PenGuin
 */
class Extend_Class extends Base_Class { //一个java里只能有一个 public 类

    @Override
    public void testFinal() {
    }
}

public /*final*/ class Base_Class implements Cloneable {

    private int test = 0;
    public int[] buffer = new int[10];
    Point p = new Point(1, 1);

    public /*final*/ void testFinal() {
    }

    public static void change(Point p1, Point p2, Integer a, int b) {

        p1 = null;
        p2.setLocation(new Point(2, 1));
        a /= 2;
        b /= 2;
    }

    @Override
    //当成员中有对象的引用时，要注意重写clone
    protected Object clone() throws CloneNotSupportedException {
         //深度克隆
        //  Base_Class nObj = new Base_Class();
        Base_Class nObj = (Base_Class) super.clone();//最好这么写
        nObj.buffer = (int[]) buffer.clone();
        nObj.p = (Point) p.clone();

        return nObj;
    }

    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {

        Object o = new Object();
        String s = new String();

        Base_Class bc1 = new Base_Class();
        Base_Class bc2 = new Base_Class();

        bc1.buffer[1] = 1;
        bc2 = (Base_Class) bc1.clone();
        System.out.println("bc1.buffer[1] = " + bc1.buffer[1]);
        System.out.println("bc1.buffer[2] = " + bc2.buffer[1]);
        System.out.println("bc1.buffer[2] = " + bc1.p);
        System.out.println("bc1.buffer[2] = " + bc2.p);
        
        bc1.buffer[1] = 2;
        bc1.p.setLocation(2, 2);
        System.out.println("bc1.buffer[1] = " + bc1.buffer[1]);
        System.out.println("bc1.buffer[2] = " + bc2.buffer[1]);
        System.out.println("bc1.buffer[2] = " + bc1.p);
        System.out.println("bc1.buffer[2] = " + bc2.p);

//        Integer a = 2;
//        int b = 2;
//        Point p1 = new Point(1,2);
//
//        Point p2 = new Point(1,2);
//        System.out.println("a = " + a + " b = " + b + " p1 = " + p1 + " p2 = " + p2);
//        Test.change(p1,p2,a, b);
//        System.out.println("a = " + a + " b = " + b + " p1 = " + p1 + " p2 = " + p2);//只有p2变了
//
//        Test bc = new Test();
//        System.out.println(bc);



    }
}
