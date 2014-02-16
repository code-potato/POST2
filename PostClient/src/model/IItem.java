/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
//import post.*;

/**
 *
 * @author David
 */
public interface IItem extends java.rmi.Remote{
  
    public void setProductSpec(ProductSpec productSpec) throws RemoteException;
    public void setQuantity(int quantity) throws RemoteException;
    public String getUPC() throws RemoteException;
    public int getQuantity() throws RemoteException;
    public float getPrice() throws RemoteException;
    public String getDescription() throws RemoteException;

  
}
