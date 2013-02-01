/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author PenGuin
 */
public class RuntimeExceptionTest {
       static void OneMethod()/*throws Exception*/{//这里程序中没有 throws Exception
           throw new RuntimeException("from OneMethod");//其他异常必须被捕获
       }
       static void TwoMethod(){
           OneMethod();
       }

       static void ThreeMethod(){
           TwoMethod();
       }
       public static void main(String[] args) {
      ThreeMethod();
}
}


