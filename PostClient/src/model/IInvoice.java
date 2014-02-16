/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public interface IInvoice extends java.rmi.Remote{
    
    public String toString();
    public void print() throws RemoteException;
    void setAmountReturned(double amount) throws RemoteException;
	
}
