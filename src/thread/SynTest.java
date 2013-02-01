/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author PenGuin
 */
class FooOne_Syn extends Thread {

    private int val;
    private String x = "A";

    public FooOne_Syn(int v) {
        val = v;
    }

    public void printVal(int v, String y) {
        synchronized (this) {
            while (v < 500) {
                System.out.println(y + ": " + v++);
            }
        }
    }

    public void run() {
        printVal(val, x);
    }
}

class FooTwo_Syn extends Thread {

    private String x = "B";
    private FooOne_Syn sameFoo;

    public FooTwo_Syn(FooOne_Syn f) {
        sameFoo = f;
    }

    public void run() {
        sameFoo.printVal(2, x);
    }
}

//只会对同一个对象的同一个方法加锁，f2与f1是不同的对象
public class SynTest {

    public static void main(String[] args) {

        FooOne_Syn f1 = new FooOne_Syn(1);
        f1.start();

        FooTwo_Syn b = new FooTwo_Syn(f1);
        b.start();

//        FooOne_Syn f2 = new FooOne_Syn(3);
//        f2.start();

    }
}
