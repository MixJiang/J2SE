/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package applet;

import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author PenGuin
 */
public class SimpleApplet extends Applet{
    @Override
   public void paint(Graphics g){
       g.drawString("SimpleApplet", 30, 30);
   }

}
