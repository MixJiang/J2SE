package generics;

import java.util.ArrayList;
import java.util.List;

class Base{}
class Derive1 extends Base{}
class Derive2 extends Base{};

public class GenericArray<T> {

	private T[] array;
	public GenericArray(int size){
		array = (T[])new Object[size];
	}
	public T[] getDataArray(){
		return array;
	}
	
	public T getData(){
		return array[0];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//数组类型一开始就定义好了的，不能进行整体转换，只能对一个一个数组元素进行转换，这种转换也是不安全的
		Base[] base = new Derive1[2];
		base[0] = new Derive2();//抛出异常
		
		//容器对数组进行了封装，只能获得其引用，不能改变其类型，所以是安全的
		List<Base> list = new ArrayList<Base>();
		list.add(new Derive1());
		for( int i = 0; i < list.size(); i++){
			Base b = list.get(i);
			b = new Derive2();//正常运行
		}
	}

}
