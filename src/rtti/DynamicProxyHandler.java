package rtti;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface SomeMethods{
	public void f1();
	public void f2(String s);
}

class Implementation implements SomeMethods{

	@Override
	public void f1() {
		System.out.println("Call f1");		
	}

	@Override
	public void f2(String s) {
		System.out.println(s + " Call f2");
	}
	
}

public class DynamicProxyHandler implements InvocationHandler {

	private Object proxy;
	public DynamicProxyHandler(Object proxy){
		this.proxy = proxy;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		if(method.getName().equals("f1")){
			System.out.println("choose f1");
		}
		return method.invoke(this.proxy, args);
	}
	
	public static void main(String[] args) {
		
		SomeMethods s = (SomeMethods)Proxy.newProxyInstance(
				SomeMethods.class.getClassLoader(),
				new Class[]{SomeMethods.class}, 
				new DynamicProxyHandler(new Implementation()));
		
		s.f1();
		s.f2("hello");
		
	}


}
