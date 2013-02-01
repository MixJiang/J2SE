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
public class Collection_Test {
	
    public static void main(String[] args) {
    	
        Collection c1 = new ArrayList(25);//这里c1只有Collection接口里面的东西，ArrayList里面的一些接口丢失了,比如说有序性
        c1.add(new String("One"));
        String s = "Two";
        c1.add(s);

        ArrayList c2 = new ArrayList(25);
        c2.add(2);
        c2.add(new String("One"));

        c1.removeAll(c2); //求差集

        System.out.println(c2);

        System.out.println(c1.toString());

        Object[] array = c1.toArray(); //和接口情况是一样的

        Object[] o = new Object[4];//在这里，o.length这个方法只有在数组情况下采用，所以显示的颜色都不一样

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
