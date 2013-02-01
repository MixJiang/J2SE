package collection;

import java.util.Iterator;

public class IterableBean implements Iterator{

	private int count = 0;
	
	public IterableBean(int count){
		this.count = count;
	}
	@Override
	public boolean hasNext() {
		if(count != 0){
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		return count--;
	}

	@Override
	public void remove() {
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Iterator iterator = new IterableBean(5);
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}

}
