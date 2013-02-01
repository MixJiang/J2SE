package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new File("out.txt"));
		float a = s.nextFloat();
		System.out.print(a);
	}

}
