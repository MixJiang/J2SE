/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author PenGuin
 */
public class MyPriorityThread extends Thread{
int count = 1,number;
     public MyPriorityThread(int num, int priority){
         setPriority(priority);
         number = num;
         System.out.println("创建线程 " + number);
     }
     public void run(){
         while (true){
             System.out.println("线程 " + number + ":计数 " + count);
             if(++count == 10) return ;
     }
  }
     public static void main(String[] args) {
         new MyPriorityThread(3, Thread.MAX_PRIORITY).start();
         for (int i = 0; i < 2; i++) {
             new  MyPriorityThread(i + 1,Thread.MIN_PRIORITY).start();
         }

    }
}
