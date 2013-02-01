/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rmitest;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author PenGuin
 */
interface I_Hello extends Remote{
public String sayHello() throws RemoteException;
}
