package generics;

import java.util.ArrayList;
import java.util.List;


class A<T extends Object>{
	
	public T t;
	public A(T t){
		this.t = t;
	}
	public boolean compare(T t1, T t2){
		return t1.equals(t2);
	}
}

public class MyGenerics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
            A a = new A(123);
            double b = 123;
            double c = 123;
            Integer d = new Integer(5);
            System.out.println(a.compare(b, c));
            
            
	}

}
