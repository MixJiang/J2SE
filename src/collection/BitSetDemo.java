/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 *
 * @author PenGuin
 */
public class BitSetDemo {
//处理很多有选项的问题
    public static void main(String[] args) {
        BitSet aBitSet = new BitSet();
        BitSet bBitSet = new BitSet();

        for (int i = 10; i < 20; i++) {
            aBitSet.set(i);
        }
        aBitSet.set(5);
        
        for (int i = 5; i < 15; i++) {
            bBitSet.set(i);
        }

        aBitSet.and(bBitSet);

        System.out.println("aBitSet = " + aBitSet);
        //输出到最后一个true为止
        for (int i = 0; i < aBitSet.length(); i++) {           
            System.out.println(aBitSet.get(i));
        }
        
        System.out.println(aBitSet.length());

    }
}
