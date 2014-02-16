/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
//import post.*;


/**
 *
 * @author David
 */
public interface IStore extends java.rmi.Remote{
    
    public Post getPost() throws RemoteException;
    public void newPost() throws Exception, RemoteException;
    public void addProductToCatalog(ProductSpec product) throws RemoteException;
    public boolean hasProduct(String upc) throws RemoteException;
    public ProductSpec getProduct(String upc) throws RemoteException;
    public void saveTransaction(TransactionRecord transaction) throws RemoteException;
    public String getName() throws RemoteException;
	
	
}
