package test;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerialObject<E> implements Serializable,Externalizable{
	
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
	
    private  String str = null;
    


	public String getStr() {
		return str;
	}


	public void setStr(String str) {
		this.str = str;
	}


	public static void main(String[] args) throws Exception {
		  
		  FileOutputStream fileOutputStream = new FileOutputStream("1.txt");
		  ObjectOutputStream  objectOutputStream = new ObjectOutputStream(fileOutputStream); 
		  
		  SerialObject<Integer> serialObject = new SerialObject<Integer>();
		  serialObject.setNum(2);
		  serialObject.setStr("123");
		  
		  objectOutputStream.writeObject(serialObject);
		  
		  FileInputStream fileInputStream = new FileInputStream("1.txt");
		  ObjectInputStream  objectInputStream = new ObjectInputStream(fileInputStream);
		  
		  SerialObject obj = (SerialObject) objectInputStream.readObject();
//		  System.out.println(obj.getNum());
//		  System.out.println(obj.getStr());
		  List l = new ArrayList();
		  
		  String[] sa = new String[100];

		  sa[0] = "hello world";

		  Object[] oa = sa;

		  oa[0] = new Integer(1);
		  System.out.println(oa.length);
//		  System.out.println(sa[0]);
	  }


	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println(in.readInt());
		System.out.println(in.readObject());
	}


	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(1);
		out.writeObject(str);
	}

}
