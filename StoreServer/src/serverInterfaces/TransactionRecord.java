/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
//import post.*;

/**
 *
 * @author David
 */
public interface TransactionRecord extends java.rmi.Remote{
    
    public String getCustomerFirstName() throws RemoteException;
    public String getCustomerLastName() throws RemoteException;
    public boolean addItem(Item item) throws RemoteException;
    public void setPayment(Payment pay) throws RemoteException;
    public Payment getPayment() throws RemoteException;
    public Date getDateAndTime() throws RemoteException;
    public ArrayList getItems() throws RemoteException;

	
}
