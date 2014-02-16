package postInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import serverInterfaces.*;

/**
 *
 * @author Michael Santer
 */
public interface Payment extends java.rmi.Remote {
    
    public double processPayment(double total) throws RemoteException;
    
    public void setAmount(Double amount) throws RemoteException;
    
    public double getAmount() throws RemoteException;
    
}