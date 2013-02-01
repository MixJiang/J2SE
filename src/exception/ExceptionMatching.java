/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author PenGuin
 */
class BaseException extends Exception{}
class ExtendException extends BaseException{}

public class ExceptionMatching {
     public static void main(String[] args) {
       /* 方案一：都能被捕捉到 */
         System.out.println("方案一: ");
         try {
             //Exception只能被捕捉一次
             throw new BaseException();
             //throw new ExtendException();
         } catch (ExtendException e) {
             System.out.println("Caught ExtendException");
         }
         catch(BaseException e){
             System.out.println("Caught BaseException");
         }

         //基类的异常能捕捉扩展类的异常
         System.out.println("方案二: ");
         try {
             throw new ExtendException();
         }
         catch(BaseException e){
             System.out.println("Caught BaseException");
         }
         

         //方案三： 基类和扩展类换位置话，扩展类的异常永远不会被捕捉到,编译会错误
          System.out.println("方案三: ");
         try {
             throw new ExtendException();
         } 
         catch(BaseException e){
             System.out.println("Caught BaseException");
         }
//         catch (ExtendException e) {
//             System.out.println("Caught ExtendException");
//         }
        
    }
}
