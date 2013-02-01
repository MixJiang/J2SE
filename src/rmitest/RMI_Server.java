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

public class RMI_Server {

    public static void main(String[] args) {
        try {
            Hello hello = new Hello();
            Naming.rebind("RMI_Hello", hello);
            System.out.println("=====Hello Server is Ready=====");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}