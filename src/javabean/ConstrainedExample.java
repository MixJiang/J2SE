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
public class ConstrainedExample extends Panel{
private String myStr;//原本普通的属性

  private PropertyChangeSupport changes = new PropertyChangeSupport(this);
  private VetoableChangeSupport vetos = new VetoableChangeSupport(this);


  public ConstrainedExample(){
      myStr = "Helle Java Bean";
  }


    public String getMyStr() {
        return myStr;
    }

    public void setMyStr(String newStr) throws PropertyVetoException {
        String oldStr = myStr;
        vetos.fireVetoableChange("mystr", oldStr, newStr);//若有其他对象否决myStr的改变，抛出异常不执行下面的两个语句了

        this.myStr = newStr;
        changes.firePropertyChange("myStr", oldStr, newStr);//这样就变成关联属性了

    }

    public void addPropertyChangeListener(PropertyChangeListener l){
            changes.addPropertyChangeListener(l);

    }
     public void removePropertyChangeListener(PropertyChangeListener l){
            changes.removePropertyChangeListener(l);
    }

    public void addVetoableChangeListener(VetoableChangeListener l){
            vetos.addVetoableChangeListener(l);

    }
     public void removeVetoableChangeListener(VetoableChangeListener l){
            vetos.addVetoableChangeListener(l);
    }
}
