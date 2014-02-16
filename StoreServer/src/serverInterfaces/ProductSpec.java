/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author David
 */
public interface ProductSpec extends java.rmi.Remote{
    
    public void setUPC(String UPC) throws RemoteException;
    public void setDescription(String description) throws RemoteException;
    public void setPrice(float price) throws RemoteException;
    public String getUPC() throws RemoteException;
    public String getDescription() throws RemoteException;
    public float getPrice() throws RemoteException;
	
	
}
