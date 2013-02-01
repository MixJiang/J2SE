/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 * 
 * @author PenGuin
 */

class ExtendedMyException extends Exception {

	private static final long serialVersionUID = 1L;
	private int i;

	public ExtendedMyException() {
	}

	public ExtendedMyException(String message) {
		super(message);
	}

	public ExtendedMyException(String message, int x) {
		super(message);
		i = x;
	}

	public int gerVal() {
		return i;
	}

}

public class ExtraSefExceptionTest {

	public static void first() throws ExtendedMyException {
		System.err.println("throw ExtendedMyException from first()");// 使用 serr
																		// 能把次序给调准了
																		// sout的话
																		// 文本的输出和异常的输出不在一块儿
		throw new ExtendedMyException();
	}

	public static void second() throws ExtendedMyException {
		System.err.println("throw ExtendedMyException from second()");
		throw new ExtendedMyException("from second()");
	}

	public static void third() throws ExtendedMyException {
		System.err.println("throw ExtendedMyException from third()");
		throw new ExtendedMyException("from third()", 108);
	}

	public static void main(String[] args) {
		try {
			first();
		} catch (ExtendedMyException e) {
			e.printStackTrace(System.err);
		}

		try {
			second();
		} catch (ExtendedMyException e) {
			e.printStackTrace(System.err);
		}

		try {
			third();
		} catch (ExtendedMyException e) {
			e.printStackTrace(System.err);
			System.err.println("e.getVal() = " + e.gerVal());
		}
	}
}
