/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author PenGuin
 */
public class BoundListener {

    public void toBepropertyChangeListenerofBoundExample(BoundExample be){
            be.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {//当be的关联属性被改动 这个函数就会自动调用
                System.out.println("OldValue:" + evt.getOldValue());
                System.out.println("NewValue:" + evt.getNewValue());
                System.out.println("tPropertyName:" + evt.getPropertyName());

            }
        });
    }
    public static void main(String[] args) {
        BoundExample be = new BoundExample();
        BoundListener bl = new BoundListener();

        bl.toBepropertyChangeListenerofBoundExample(be);
       
        be.setMyStr("Hello World");
        
//        be.addPropertyChangeListener(new PropertyChangeListener() {
//
//            public void propertyChange(PropertyChangeEvent evt) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
//        });
    }
}
