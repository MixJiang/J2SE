/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rmitest;

/**
 *
 * @author PenGuin
 */
import java.io.PrintStream;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;


public class Hello extends UnicastRemoteObject implements I_Hello{
   public Hello() throws RemoteException{
       System.out.println("初始化远程对象");
   }
   public String sayHello(){
       return "hello Java!!!";
   }
}