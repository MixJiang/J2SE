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
public class HashCode_Test {
     private static List created = new ArrayList();
     private String s;
     private int id = 0;

     public HashCode_Test(String str) throws Exception{
    	 
         s = str;
         Iterator it = created.iterator();
         
         while(it.hasNext()){
        	 //如果字符串相同，那么不能添加
             if(it.next().equals(s)){
            	 throw new Exception("字符串是主键，不能添加一样的字符串");
             }
             id++;
         }
         
         created.add(s);
     }
     
    @Override
    public String toString(){
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }
   
    @Override
    public int hashCode(){
        int rezult = 17;
        rezult = 37 * rezult + s.hashCode();
        rezult = 37 * rezult + id;
        return rezult;
    }

    @Override
    public boolean equals(Object o){ 
        return  (o instanceof HashCode_Test) && s.equals(((HashCode_Test)o).s) && (id == ((HashCode_Test)o).id);
    }
    
    public static void main(String[] args) {
    	
        Map map = new HashMap();
        HashCode_Test[] cs = new HashCode_Test[10];

        for (int i = 0; i < cs.length; i++) {
        	
            try {
				cs[i] = new HashCode_Test("hello" + i);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
            map.put(cs[i], new Integer(i));
        }

//       //输出map结果不按顺序来
//        System.out.println(map);
//
//        //按顺序来
        for (int i = 0; i < cs.length; i++) {
              System.out.print("Look up " + cs[i] + " value== ");
              System.out.println(map.get(cs[i]));
        }
    }
}
