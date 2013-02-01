/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author PenGuin
 */
public class finalizeDemo {

    private static int Max = 5;
    private static int count = 0;

    public finalizeDemo() {
        if (count < Max) {
            count++;
        } else {
            System.out.println("count > Max");
            System.exit(1);
        }

    }

    @Override
    //对于C++的析构函数，能在f()结束后准时准地的被调用,而java的finalize()则不行
    protected void finalize() throws Throwable {
        count--;
    }

    public static void f() {
        finalizeDemo demo = new finalizeDemo();
        System.out.println("Inside f ,count is :" + count);
        
        Runtime rt = Runtime.getRuntime();
        demo = null;
        rt.gc();
        
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            f();
        }
    }
}
