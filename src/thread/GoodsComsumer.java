/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PenGuin
 */
public class GoodsComsumer implements Runnable{

     private GoodsBufferPool goodsBufferPool;

    public GoodsComsumer(GoodsBufferPool goodsBufferPool) {
        this.goodsBufferPool = goodsBufferPool;
        new Thread(this,"Comsumer").start();
    }

    public void run() {
        while (true) {
            try {
            	goodsBufferPool.waitForGet();
                goodsBufferPool.getGood();
            } catch (InterruptedException ex) {
                Logger.getLogger(GoodsComsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GoodsComsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
       
    }
}
