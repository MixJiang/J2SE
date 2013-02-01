package test;

import java.util.Arrays;

public class MyList<E> {

	private transient Object[] elementData;
	
	private int size;
	
	public MyList(){
		this(2);
	}
	
     public MyList(int size){
    	 this.elementData = new Object[size];
	}
	public void add(E element){
		ensureCapacity(size + 1);
		elementData[size++] = element;
	}
	
	public E get(int index){
		return (E) elementData[index];
	}
	
	public int size(){
		return this.size;
	}
	
	private void ensureCapacity(int currentSize){
		
		int oldCapacity = elementData.length;
		
		if(currentSize > oldCapacity){
			int newCapacity = (oldCapacity * 3)/2 + 1;
    	    if (newCapacity < currentSize){
    	    	newCapacity = currentSize;
    	    }
            elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		MyList<String> list = new MyList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		for (int i = 0; i < list.size(); i++){
			String a = list.get(i);
			System.out.println(a);
		}
		System.out.println(list.elementData.length);
	}
}
