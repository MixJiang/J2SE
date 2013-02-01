package innerclass;

interface Incrementable {
	void increment();
}

/*
 * 外围类实现接口
 */
class Callee1 implements Incrementable{

	private int i = 0;
	@Override
	public void increment() {
         i++;
		 System.out.println(i);
	}
}

class MyIncrement{
	public void increment(){System.out.println("Other Operation");}
	static void f(MyIncrement mi){mi.increment();}
}

/*
 * 内部类实现接口，这里继承一个类，实现一个接口
 */
class Callee2 extends MyIncrement{
	
	private int i = 0;
	public void increment() {
		 super.increment();
         i++;
		 System.out.println(i);
	}
	
	private class Closure implements Incrementable{

		@Override
		public void increment() {
			Callee2.this.increment();
		}
		
	}
	
	Incrementable getCallbackReference(){
		return new Closure();
	}
}

class Caller{
	
	private Incrementable callbackReference;
	Caller(Incrementable cbh){callbackReference = cbh;}
	//这里回调的时间间隔没显示出来
	void go(){callbackReference.increment();}
	
}

public class CallBacks {

	public static void main(String[] args) {

		//被调用方
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
//		MyIncrement.f(c2);
		
		//注册回调函数 即Incrementable接口的实现
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());
		
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}

}
