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
public class List_Test {
    public static List fill(List fill_a){
        fill_a.add("a");
        fill_a.add("b");
        fill_a.add("c");
        return fill_a;
        }
    private static boolean b;
    private static Object o;
    private static int i;
    private static Iterator it;
    private static ListIterator lit;
    
    public static void basicTest(List a){
        a.add(0, "x");
        a.add("x");
        System.out.println("初始List A 为" + a);
        
        a.addAll(fill(new ArrayList()));
        System.out.println("追加新的list后，List A 为" + a);
        
        a.addAll(3,fill(new ArrayList()));
        System.out.println("在3位置追加新的list后，List A 为" + a);
        
        b = a.contains("c");
        System.out.println(b);
        
        b = a.containsAll(fill(new ArrayList()));
        System.out.println(b);
        
        o = a.get(1);
        System.out.println("位置1元素的为：" + o);

        i =a.indexOf("c");
        System.out.println("c元素第一次出现的位置为：" + i);

        i =a.lastIndexOf("c");
        System.out.println("c元素最后一次出现的位置为：" + i);

        b = a.isEmpty();
        System.out.println(b);

        a.remove(1);
        System.out.println("删除1位置上的元素，List A 为" + a);

        a.remove("c");
        a.set(1, "y");
        System.out.println("删除第一个c，在1位置上添加y后，List A 为" + a);

    }
        public static void main(String[] args) {
        basicTest(new LinkedList());
    }
    }


