/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package collection;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

//这里可以不用让watcher依赖Observable，在Observable里的notifyObservers()方法中传出this就可以了
class Watcher implements Observer{

    public void update(Observable o, Object arg) {
        System.out.println("update() is called, count is " + ((Integer)arg).intValue());
    }

}

class BeingWatched extends Observable{
	
    void count(int period){
        for (int i = 0; i < period; i++) {
            setChanged();
            notifyObservers(new Integer(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BeingWatched.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
/**
 *
 * @author PenGuin
 */
public class ObservableDemo {
	
    public static void main(String[] args) {
    	
        BeingWatched beingWatched = new BeingWatched();
        Watcher watcher = new Watcher();

        beingWatched.addObserver(watcher);
        
        beingWatched.count(10);
    }
}
