package serverSharedClasses;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import serverInterfaces.*;
/**
 * Item is used by transactionRecord. It holds a product specification, and
 * the quantity that is being sold.
 * 
 * @author Michael Santer
 */
public class Item {
    private ProductSpec productSpec;
    private int quantity;
    
    public Item() throws RemoteException {   
    }

    public void setQuantity(int quantity) throws RemoteException{
        this.quantity = quantity;
    }
    
    public String getUPC()throws RemoteException{
        return productSpec.getUPC();
    }
    
    public int getQuantity()throws RemoteException{
        return quantity;
    }
    
    public float getPrice()throws RemoteException{
        return productSpec.getPrice();
    }
    
    public String getDescription() throws RemoteException{
        return productSpec.getDescription();
    }
    
    public void setProductSpec(ProductSpec productSpec) throws RemoteException{
        this.productSpec = productSpec;
    }
      
}
