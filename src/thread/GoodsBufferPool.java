/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 必须在synchronized方法里来调用wait(),notify()
 * wait(),notify()并没有在线程类里面出现，而是在共享类里面出现的
 */
public class GoodsBufferPool {

    //生产一个，消费者消费一个
    private int goodSerialNum = 0;
    private boolean lock = false;
    
    
    /**
     * 这个函数证明对象锁只跟synchronized方法有关
    */
    public void print(){
    	
    	while (true) {
    	 try {
             Thread.sleep(1000);
         } catch (InterruptedException ex) {
             Logger.getLogger(GoodsProducer.class.getName()).log(Level.SEVERE, null, ex);
         }
    	System.out.println("hello");
    	}
    }

    
    /**
     * 等待获取对象锁，放入物品
    */
    public synchronized void waitForInput() throws InterruptedException{
    	 while (lock) {
             wait();
         }
    }
    
    /**
     * 等待获取对象锁，获得物品
    */
    public synchronized void waitForGet() throws InterruptedException{
    	while (!lock) {
            wait();
        }
    }


    public synchronized void getGood() throws InterruptedException {
        
        goodSerialNum--;
        System.out.println("Get：" + goodSerialNum);
        
        lock = false;
        notify();

    }

    public synchronized void putGood() throws InterruptedException {
    	
        goodSerialNum++;
        System.out.println("Put：" + goodSerialNum);
        
        lock = true;
        notify();

    }
}
