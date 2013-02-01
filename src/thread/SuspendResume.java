/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

class NewThread implements Runnable {

    private String threadName;
    public Thread t;
    private boolean suspendFlag = false;

    public NewThread(String threadName) {
        this.threadName = threadName;
        t = new Thread(this, threadName);
        t.start();
    }

    public void suspend() {
        suspendFlag = true;
    }

    public synchronized void resume() {
        suspendFlag = false;
//        notify();
    }

    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                System.out.println(threadName + ": " + i);
                Thread.sleep(300);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(NewThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

/**
 *
 * @author PenGuin
 */
public class SuspendResume {

    public static void main(String[] args) throws InterruptedException {
        
        NewThread thread1 = new NewThread("One");
        NewThread thread2 = new NewThread("Two");

        Thread.sleep(1000);

        thread1.suspend();
        System.out.println("suspend other.thread One");

        Thread.sleep(1000);
        thread1.resume();
        System.out.println("resume other.thread One");

        thread2.suspend();
        System.out.println("suspend other.thread Two");

        Thread.sleep(1000);
        thread2.resume();
        System.out.println("resume other.thread Two");

        thread1.t.join();
        thread2.t.join();

        System.out.println("StepOfClassInit thead Exit");
    }
}
