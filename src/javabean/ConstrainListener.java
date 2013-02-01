/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javabean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeListener;
/**
 *
 * @author PenGuin
 */
public class ConstrainListener {
    public void toBevetoableChangeListenerOfConstrainedExample(ConstrainedExample ce){
                ce.addVetoableChangeListener(new VetoableChangeListener() {

                public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                System.out.println("OldValue:" + evt.getOldValue());
                System.out.println("NewValue:" + evt.getNewValue());
                System.out.println("tPropertyName:" + evt.getPropertyName());
//                if (evt.getOldValue() != evt.getNewValue()) {
//
//                }
            }
        });

    }

    public void toBepropertyChangeListenerofConstrainedExample(ConstrainedExample ce){
               ce.addPropertyChangeListener(new PropertyChangeListener() {

                public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("OldValue:" + evt.getOldValue());
                System.out.println("NewValue:" + evt.getNewValue());
                System.out.println("tPropertyName:" + evt.getPropertyName());

            }
        });
    }
    public static void main(String[] args) throws PropertyVetoException {
        ConstrainedExample ce = new ConstrainedExample();
        ConstrainListener cl = new ConstrainListener();

        cl.toBevetoableChangeListenerOfConstrainedExample(ce);

        cl.toBepropertyChangeListenerofConstrainedExample(ce);

        ce.setMyStr("Hello World");//这个放后面的都行
    }

}
