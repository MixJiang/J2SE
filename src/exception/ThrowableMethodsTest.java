/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author PenGuin
 */

//异常发生后，先打印异常的基本信息，然后打印异常的发生路径，err打印时将是红色
public class ThrowableMethodsTest {
    private void getThrowable(){

        try {
            throw new Throwable("this is throwable");
        } catch (Throwable e) {

            System.err.println("caught Throwable");
            System.err.println("e.getMessage(): " + e.getMessage());
            System.err.println("e.toString(): " + e.toString());//比getMessage()更全面

            System.err.println("e.printStackTrace: " );
            e.printStackTrace(); //可以自己输出，也可以按下面的

//            StackTraceElement[] stackElement = e.getStackTrace();//返回的一个数组的初始地址
//            System.out.println("stackElement[]:");
//            for (int i = 0; i < stackElement.length; i++) {
//                System.out.println("stackElement["+ i +"]: " + stackElement[i].toString());
//
//            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new ThrowableMethodsTest().getThrowable();
        Thread.sleep(1000);//异常的抛出是另外开了一个现成？
        System.out.println("Hello World!");
    }

}
