/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.IOException;
//import post.Post;

/**
 *
 * @author David
 */
public interface IManager extends java.rmi.Remote{
    
    public void openStore(String storeName) throws RemoteException;
    public void setupProductCatalog(String productCatalogFile) throws IOException, RemoteException;
    public void initPost() throws Exception, RemoteException;
    public Post getPost() throws Exception, RemoteException;
}
