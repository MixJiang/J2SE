/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package collection;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyTimerTask extends TimerTask{

    public void run() {
        System.out.println("MyTimerTask is executed!");
    }

}
/**
 *
 * @author PenGuin
 */
public class TimerTaskDemo {
    public static void main(String[] args) {
    	
        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();

        myTimer.schedule(myTask, 1000,5000);
        
    }
}
