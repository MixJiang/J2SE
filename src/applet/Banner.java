/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PenGuin
 */
public class Banner extends Applet implements Runnable {

    String msg = " I am a programmer ";
    Thread t = null;
    boolean stopFlag = false;

    public void init() {
        setBackground(Color.cyan);
    }

    public void start() {
        t = new Thread(this);
        t.start();
        stopFlag = false;
    }

    public void stop() {
        t = null;
        stopFlag = true;
    }

    public void run() {
        char ch;
        while (true) {
            
            repaint();
            
            ch = msg.charAt(0);
            msg = msg.substring(1, msg.length());
            msg += ch;

            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Banner.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (stopFlag == true) {
                break;
            }
        }
    }

    public void paint(Graphics g) {
        g.drawString(msg, 50, 30);
    }
}
