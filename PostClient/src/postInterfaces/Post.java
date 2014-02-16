package postInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import serverInterfaces.*;

/**
 *
 * @author Michael Santer
 */
public interface Post extends java.rmi.Remote{
    
    public void transact(TransactionRecord transaction) throws Exception, 
                                                        RemoteException;
}
