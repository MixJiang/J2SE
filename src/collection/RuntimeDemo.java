/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.io.IOException;

/**
 *
 * @author PenGuin
 */
public class RuntimeDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        Runtime rt = Runtime.getRuntime();
//
//        Process p = null;
//
//        p = rt.exec("E:\\Guess_Number.exe");
//        p.waitFor();//等待Guess_Number.exe执行完毕
//
//        System.out.println(p.exitValue());

        
        long mem1, mem2;
        Integer[] someints = new Integer[1000];

        System.out.println("Total memery is:" + rt.totalMemory());

        mem1 = rt.freeMemory();
        System.out.println("Initial freeMemory is:" + mem1);

        rt.gc();

        mem1 = rt.freeMemory();
        System.out.println("After garbage collection , freeMemory is:" + mem1);

        for (int i = 0; i < someints.length; i++) {
            someints[i] = new Integer(i);
        }

        mem2 = rt.freeMemory();
        System.out.println("After allocation , freeMemory is:" + mem2);
        System.out.println("Memery used by allocation::" + (mem1 - mem2));

        for (int i = 0; i < someints.length; i++) {
            someints[i] = null;
        }

        rt.gc();

        mem1 = rt.freeMemory();
        System.out.println("After garbage collection , freeMemory is:" + mem1);


    }
}
