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
public class GoodsProducer implements Runnable {

    private GoodsBufferPool goodsBufferPool;

    public GoodsProducer(GoodsBufferPool goodsBufferPool) {
        this.goodsBufferPool = goodsBufferPool;
        new Thread(this, "Producer").start();
    }

    public void run() {
    	
    	 try {
             Thread.sleep(1000);
         } catch (InterruptedException ex) {
             Logger.getLogger(GoodsProducer.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        while (true) {
            try {
            	goodsBufferPool.waitForInput();
                goodsBufferPool.putGood();
            } catch (InterruptedException ex) {
                Logger.getLogger(GoodsProducer.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GoodsProducer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
