/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

/**
 *
 * @author PenGuin
 */
public class MyThread extends Thread{
     int count = 1,number;
     public MyThread(int num){
         number = num;
         System.out.println("创建线程 " + number);
     }
    @Override
     public void run(){
         while (true){
             System.out.println("线程 " + number + ":计数 " + count);
             if(++count == 10) return ;
     }
  }
     public static void main(String[] args) {
         for (int i = 0; i < 3; i++) {
             new MyThread(i + 1).start();
         }
    }
}
