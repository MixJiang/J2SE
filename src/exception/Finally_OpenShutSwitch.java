/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author PenGuin
 */
class Switch{
    boolean state = false;
    boolean read(){return state;}
    void open(){state = true;}
    void shut(){state = false;}
}

class OpenshutException1 extends Exception{}
class OpenshutException2 extends Exception{}

public class Finally_OpenShutSwitch {
       static Switch sw = new Switch();
       static void f() throws OpenshutException1,OpenshutException2{}
       public static void main(String[] args) {
           try {
               sw.open();
               f();
               sw.shut();
           } catch (OpenshutException1 e1) {
               System.err.println("OpenshutException1");
               //sw.shut(); 当try里面的异常不是 OpenshutException1 或者 OpenshutException1 就麻烦大了 所以改用 finally
           }
           catch (OpenshutException2 e2) {
               System.err.println("OpenshutException2");
               //sw.shut(); 加finally之前，把这个注释掉系统不会报错，所以要特别
           }
           finally {
               sw.shut();
           }

    }
}
