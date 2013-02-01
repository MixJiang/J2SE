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
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();

        ts.add(new Students(2,"zhangshan"));
        ts.add(new Students(1,"wangwu"));
        ts.add(new Students(3,"zhangsan"));
        ts.add(new Students(3,"pengguin"));

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

//Students放在TreeSet里面 必须要实现一个比较的方法 如Comparable接口里面的 compareTo 方法 
class Students implements Comparable{
	
    int num;
    String name;
    Students(int num, String name){
        this.num = num;
        this.name = name;

    }

    public String toString(){
        return num + ":" + name;
    }

	@Override
	public int compareTo(Object o) {
		Students student = (Students)o;
		return name.compareTo(student.name);
	}

    //或者定义一个内部类 这个没成功
//    static class compareTOStudent implements Comparator{
//
//        public int compare(Object o1, Object o2) {
//            Students s1 = (Students)o1;
//            Students s2 = (Students)o2;
//            int result  = s1.num > s2.num ? 1 : (s1.num == s2.num ? 0 : -1);
//        if (result == 0) {
//
//            result = s1.name.compareTo(s2.name);//注意这里是 comparTo ,String类自带的
//        }
//
//        return result;
//        }

//    }
}