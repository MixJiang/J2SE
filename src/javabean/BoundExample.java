/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javabean;

import java.awt.*;
import java.beans.*;
/**
 *
 * @author PenGuin
 */
public class BoundExample {
  private String myStr;//原本普通的属性

  private PropertyChangeSupport changes = new PropertyChangeSupport(this);

  public BoundExample(){
      myStr = "Helle Java Bean";
  }


    public String getMyStr() {
        return myStr;
    }

    public void setMyStr(String newStr) {
        String oldStr = myStr;
        this.myStr = newStr;

        changes.firePropertyChange("myStr", oldStr, newStr);//这样就变成关联属性了

    }

    public void addPropertyChangeListener(PropertyChangeListener l){
            changes.addPropertyChangeListener(l);

    }
     public void removePropertyChangeListener(PropertyChangeListener l){
            changes.removePropertyChangeListener(l);
    }

 //这样也行
//    public static void main(String[] args) {
//         BoundExample be = new BoundExample();
//
//        be.addPropertyChangeListener(new PropertyChangeListener() {
//
//            public void propertyChange(PropertyChangeEvent evt) {
//                System.out.println("OldValue:" + evt.getOldValue());
//                System.out.println("NewValue:" + evt.getNewValue());
//                System.out.println("tPropertyName:" + evt.getPropertyName());
//            }
//        });
//        be.setMyStr("Hello World");
//    }

}
