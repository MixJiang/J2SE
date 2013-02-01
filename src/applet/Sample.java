/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author PenGuin
 */
public class Sample extends Applet implements AppletInterface {

    String msg;

    @Override
    public void init() {
        setBackground(Color.cyan);
        msg = "Inside init()";
        System.out.println(msg);
    }

    @Override
    public void start() {
        msg = "Inside start()";
        System.out.println(msg);
    }

    @Override
    public void stop() {
        msg = "Inside stop()";
        System.out.println(msg);
    }

    public void paint(Graphics g) {
        msg = "Inside paint()";
        g.drawString(msg, 10, 30);
        System.out.println(msg);
        showStatus(msg);
    }
}
