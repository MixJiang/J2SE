/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.*;

/**
 *
 * @author PenGuin
 */
public class Set_Test {

    static void fill(Set s) {
        s.addAll(Arrays.asList("two one three four five six seven".split(" ")));

    }

    public static void test(Set s) {
    	
        System.out.println("s.getClass().getName() =" + s.getClass().getName());
        System.out.println("\\w+\\.");
        System.out.println(s.getClass().getName().replaceAll("\\w+\\.", ""));
        
        fill(s);
        
        System.out.println(s);
//         s.addAll(s);//没有任何实际意义
//         System.out.println(s);
    }

    public static void main(String[] args) {
    	
        test(new HashSet());
        test(new TreeSet());
        test(new LinkedHashSet());
        
    }
}
