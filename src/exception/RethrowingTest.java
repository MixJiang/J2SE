/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author PenGuin
 */
public class RethrowingTest {

    public static void One() throws Exception {
        System.err.println("exception in One()");
        throw new Exception("thrown from One()");
    }

    public static void Two() throws Throwable {
        try {
            One();
        } catch (Exception e) {
            System.err.println("Inside Two(), e.printStackTrace()");
            e.printStackTrace();
//            throw e; //这里与main中捕获的异常是一样的
              throw e.fillInStackTrace(); //这里导致main里面捕获的异常重Two()函数开始
        }
    }

    public static void main(String[] args) throws Throwable  { //因为有 throws Throwable  Two（）才能被调用
        try {
            Two(); //没有初始化类
        } catch (Exception e) {
            System.err.println("Caught in main, e.printStackTrace()");
            e.printStackTrace();
        }
    }
}
