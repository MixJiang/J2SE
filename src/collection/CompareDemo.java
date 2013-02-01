/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author PenGuin
 */
public class CompareDemo implements Comparator {

    public int compare(Object aName, Object bName) {

        String aStr = (String) aName;
        String bStr = (String) bName;

        int i = aStr.lastIndexOf(' ');
        int j = bStr.lastIndexOf(' ');

        String aFirstName = aStr.substring(i + 1);
        String bFirstName = bStr.substring(j + 1);

        int comp = aFirstName.compareTo(bFirstName); 
        
        if (comp == 0) {
            return aStr.compareTo(bStr);
        }

        return comp;
    }

    public static void main(String[] args) {

        TreeMap tm = new TreeMap(new CompareDemo());
        
        List list = new ArrayList();

        tm.put("John Deo", new Double(3333.12));
        tm.put("Tom Simth", new Double(4444.12));
        tm.put("Will Simth", new Double(5555.12));

        Set set = tm.entrySet();
        Iterator itr = set.iterator();

        while (itr.hasNext()) {
            Map.Entry me = (Map.Entry)itr.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }
    }
}
