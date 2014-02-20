package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import serverInterfaces.*;
import serverSharedClasses.*;

/**
 * Store contains a productCatalog, a POST, and a transactionRecord history.
 *
 * @author Michael Santer
 */
class StoreImpl extends UnicastRemoteObject implements Store {

    private String name;
    //private Post post;
    private ProductCatalog productCatalog;
    private ArrayList<TransactionRecord> transactionHistory;

    public StoreImpl() throws RemoteException {
        this.name = "Default Store";
        productCatalog = new ProductCatalog();
        transactionHistory = new ArrayList<TransactionRecord>();
    }

//    public Post getPost(){
//        return post;
//    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Creates a new POST.
     *
     * @throws Exception if POST has already initialized.
     */
//    public void newPost() throws Exception {
//        if (post != null)
//            throw new Exception("Post already exists!");
//        post = new Post(this);
//    }
    /**
     * Adds a single product to the product catalog.
     *
     * @param product
     */
    public void addProductToCatalog(ProductSpec product) throws RemoteException {
        productCatalog.addProductToCatalog(product);
    }

    /**
     * Given a upc, checks if the product exists in the productCatalog.
     *
     * @param upc
     * @return true if product exists, false if not.
     */
    public boolean hasProduct(String upc) {
        return productCatalog.hasProduct(upc);
    }

    /**
     * Returns the product spec for a given upc.
     *
     * @param upc
     * @return ProductSpec
     */
    @Override
    public ProductSpec getProduct(String upc) {
        return productCatalog.getProduct(upc);
    }

    @Override
    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public String[] getUPCs() {
        return productCatalog.getUPCs().toArray(new String[0]);
    }

    /**
     * Saves a single transactionRecord to transactionHistory.
     *
     * @param transaction
     */
    public void saveTransaction(TransactionRecord transaction) {
        transactionHistory.add(transaction);
    }

    public String getName() {
        return name;
    }

}
