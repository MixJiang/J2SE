/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author PenGuin
 */
class FooOne extends Thread {

    private int val;
    private String x = "A";

    public FooOne(int v) {
        val = v;
    }

    public /*synchronized */void printVal(int v, String y) {
        while (v < 50) {
            System.out.println(y + ": " + v++);
        }
    }

    public   void run() {
      printVal(val, x);
    }
}

class FooTwo extends Thread {

    private String x = "B";
    private FooOne sameFoo;

    public FooTwo(FooOne f) {
        sameFoo = f;
    }

    public void run() {
        sameFoo.printVal(2, x);
    }
}
//结果很不稳定
public class NoSynTest {

    public static void main(String[] args) throws InterruptedException {

        FooOne f1 = new FooOne(1);
        f1.start();

        FooTwo b = new FooTwo(f1);
        b.start();

    }
}
