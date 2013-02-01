/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;
import java.io.*;

/**
 *
 * @author PenGuin
 */
class SimpleException extends Exception{
    public SimpleException(String s){ super(s);}//构造函数不能默认继承的
}

public class RethrowingOthExcepTest {
    public static void One() throws Exception{
        System.err.println("exception One");
        throw new Exception("here is Exception");
    }

    public static void Two() throws Throwable{
         try {
            One();
        } catch (Exception e) {
             System.err.println("Inside Two() , ex.printStackTrace");
             e.printStackTrace(); //为了演示

             throw new SimpleException("here is SimpleException");
        }
    }
    
    public static void main(String[] args) throws Throwable{
        try {
              Two();
        } catch (Exception e) {
            System.err.println("Caught in main , e.printStackTrace");
            e.printStackTrace();
        }

    }





   

}
