package server;

/**
 * ProductCatalog contains all productSpecs matched with a UPC. 
 * @author David
 */

import java.rmi.RemoteException;
import java.util.HashMap;
import serverInterfaces.*;

public class ProductCatalog {

    //a map of UPC's and the matchem product
    private HashMap<String,ProductSpec> catalog;
    
    public ProductCatalog(){  
        catalog = new HashMap<String,ProductSpec>();
    }
    
    public void addProductToCatalog(ProductSpec product) throws RemoteException{
        catalog.put(product.getUPC(), product);
    }

    public boolean hasProduct(String upc) {
        return catalog.containsKey(upc);
    }

    public ProductSpec getProduct(String upc) {
        return catalog.get(upc);
    }
    
}
