package rtti;

import java.lang.reflect.Method;

class A{
	public void f(){System.out.print("Call f");};
}

class B extends A{
	private void g(){System.out.print("Call g");};
}

public class CallMethodUseRTTI {

	public static void main(String[] args) throws Exception {
           A a =new B();
//           B b = (B)(a);
           B b = new B();
           String method = "g";
           callMethod(b, method);
           
	}

	private static void callMethod(Object b, String method) throws Exception {
		Method g = b.getClass().getDeclaredMethod(method);
        g.setAccessible(true);
        g.invoke(b);
	}

}
