/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

/**
 *
 * @author PenGuin
 */

// 比 MyThread 稳定一些
public class Sleep_Test extends Thread{
 int count = 1,number;
     public Sleep_Test(int num){
         number = num;
         System.out.println("创建线程 " + number);
     }
     public void run(){
         while (true){
             System.out.println("线程 " + number + ":计数 " + count);
             if(++count == 10) return ;  
                       try{
                         sleep(100);
                       }
                      catch(InterruptedException ex){
                         throw new RuntimeException(ex);
                       }
    }
 } 
       public static void main(String[] args) {
            for (int i = 0; i < 3; i++) {
             new Sleep_Test(i + 1).start();
         }
    }
}
