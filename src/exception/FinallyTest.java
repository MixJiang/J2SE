/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author PenGuin
 */
class MyNewException extends Exception{}

public class FinallyTest {
      public static void main(String[] args) throws MyNewException {
            try {
                    throw new MyNewException();
            } catch (MyNewException e) {
            	
            	throw new RuntimeException(e);
            	
//            	e.initCause(new NullPointerException());
//            	e.printStackTrace();
//                System.err.println("MyNewException happened");
            }
            finally {
                System.err.println("finally is called");
                }
            }
}
