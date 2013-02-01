/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rmitest;

/**
 *
 * @author PenGuin
 */
import java.rmi.*;

public class RMI_Client {
    public static void main(String[] args) {
        try {
            I_Hello hello = (I_Hello)Naming.lookup("RMI_Hello");
            System.out.println(hello.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}