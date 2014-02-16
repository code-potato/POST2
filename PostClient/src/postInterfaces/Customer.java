package postInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import serverInterfaces.*;

/**
 *
 * @author Michael Santer
 */
public interface Customer extends java.rmi.Remote{
    
    public void setFirstName(String firstName) throws RemoteException;
    
    public void setLastName(String lastName) throws RemoteException;
    
    public String getFirstName() throws RemoteException;
    
    public String getLastName() throws RemoteException;
    
}
