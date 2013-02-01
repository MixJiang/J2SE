/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author PenGuin
 */
public class MyRunnableThread implements Runnable {

    int count = 1, number;

    public MyRunnableThread(int num) {
        number = num;
        System.out.println("创建线程 " + number);
    }

    public void run() {
        while (true) {
            System.out.println("线程 " + number + ":计数 " + count);
            if (++count == 100) {
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//         for (int i = 0; i < 3; i++) {
//             new other.thread(new MyRunnableThread(i + 1)).start();
//         }

        Thread t1 = new Thread(new MyRunnableThread(1));
        Thread t2 = new Thread(new MyRunnableThread(2));
        Thread t3 = new Thread(new MyRunnableThread(3));

        t1.start();
        t2.start();
        t3.start();

        System.out.println("t1.isAlive():" + t1.isAlive());
        System.out.println("t2.isAlive():" + t2.isAlive());
        System.out.println("t3.isAlive():" + t3.isAlive());

        t1.join();
        t2.join();
        t3.join();

        System.out.println("t1.isAlive():" + t1.isAlive());
        System.out.println("t2.isAlive():" + t2.isAlive());
        System.out.println("t3.isAlive():" + t3.isAlive());


    }
}
