package test;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

public class MemeryReadFile {
	public static void main(String[] args) throws Exception {
		
		FileWriter fileWriter = new FileWriter("2.txt");
		fileWriter.write("123");
		fileWriter.write("彭俊啊");
		fileWriter.close();
		
		
		FileInputStream fileInputStream = new FileInputStream("2.txt");
		FileChannel channel = fileInputStream.getChannel();
		
		CRC32 crc = new CRC32();
		int length = (int) channel.size();
		MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
		
		for (int i = 0; i < length; i++){
			int c = buffer.get(i);
			crc.update(c);
		}
		
		System.out.println(crc.getValue());
		int[] a = {1,2};
		int[] b = a;
		
		String c = "1";
		String d = new String(c);
		
		
		
		a[1] = 3;
		System.out.println(b[1]);
		
	}
}
