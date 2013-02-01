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
public class Map_Test {
    public static void main(String[] args) {
        
//        Map<String,Integer> m = new HashMap<String,Integer>();
//        String[] s = {"if","it","is","it","to"};
//
//        for (int i = s.length - 1; i >= 0; i--) {
//            Integer freq = m.get(s[i]);
//            m.put(s[i], (freq==null)?1:freq + 1);//左边键值 右边是值
//        }
//
//        System.out.println(m.size() + " words");
//        System.out.println(m);
        

//        HashMap hm = new HashMap();
        TreeMap hm = new TreeMap();

        /*
        hm.put(1,"A");  hm.put(2,"B");
        hm.put(3,"C");  hm.put(4,"D");
        hm.put(5,"E");  //hm.put(1,"A");
        */

        hm.put(5,"E"); hm.put(4,"D");
        hm.put(3,"C"); hm.put(2,"B");
        hm.put(1,"A"); hm.put(1,"F");//键值是唯一的

        System.out.println(hm);

        Set set = hm.keySet();

        Iterator i = set.iterator();

        while (i.hasNext()){
            Object k = i.next();
            Object v = hm.get(k);
            System.out.print("  " + k + "=" + v);
        }
        System.out.println();
    }
}
