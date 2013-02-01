package test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class AnotherSerialObject implements Serializable {

	/**
	 *  序列化时的版本号
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int num  = 0;

	  public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}
	
	public static void main(String[] args) throws Exception {
		  
//		  FileOutputStream fileOutputStream = new FileOutputStream("1.txt");
//		  ObjectOutputStream  objectOutputStream = new ObjectOutputStream(fileOutputStream); 
//		  
//		  SerialObject serialObject = new SerialObject();
//		  serialObject.setNum(2);
//		  
//		  objectOutputStream.writeObject(serialObject);
		  
		  FileInputStream fileInputStream = new FileInputStream("1.txt");
		  ObjectInputStream  objectInputStream = new ObjectInputStream(fileInputStream);
		  
		  AnotherSerialObject obj = (AnotherSerialObject) objectInputStream.readObject();
		  System.out.println(obj.getNum());
	  }
}
