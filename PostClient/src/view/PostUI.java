package view;

import post.Post;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import serverInterfaces.*;
import serverSharedClasses.*;

/**
 *
 * @author Michael Santer and friends
 *
 * PostUI handles all user interfacing. Communicates between Manager and Post.
 */
public class PostUI {

    private Manager manager;
    private Post post;
    private Store store;

    public PostUI(Manager manager, Store store) {
        this.store = store;
        this.manager = manager;
        this.post = new Post(store);
    }

    /**
     * This method handles the high level flow of the UI.
     *
     * @param manager
     */
    public void run() {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the point of sale terminal (POST)!");

        //Get name of store and ask manager to open store and init post. 
//        System.out.print("Please enter the name of the store: ");
//        try {
//            //manager.openStore(in.nextLine());
//            manager.initPost();
//            post = manager.getPost();
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//        }

        //Get name of product catalog and ask manager to initialize it. 
        System.out.print("Please enter the name of Product Catalog file: ");
        try {
            manager.setupProductCatalog(in.nextLine());
        } catch (IOException ex) {
            System.err.println("File was not found!");
            return;
        }

        for (int i = 0; i < 1; i++) {
            // (create useful condition eventually)

            //get transaction file
            System.out.print("Please enter the name of Transaction file: ");
            String transactFile = in.nextLine();

            /*Request Customer class to get transactions from file.
             *An available post is sent so that the customer can pass off the
             *transaction to the post for processing. */
            TransactionRecord transaction = null;
            try {
                transaction = Customer.getTransactions(transactFile);
            } catch (IOException ex) {
                System.err.println("Error reading file. Check file format.");
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
            
            // 1. process transaction, 2. save transaction, 3. print invoice
            if(transaction != null)
                try {
                    post.transact(transaction);
                    store.saveTransaction(transaction);
                    System.out.println("transaction done");
                    //Invoice invoice = new Invoice(transaction, store);
            } catch (RemoteException ex) {
                Logger.getLogger(PostUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PostUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
    }
    
    public static void main(String[] args){
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        
        try{
            //get manager object through RMI connection
            Registry rmtReg = LocateRegistry.getRegistry("localhost");
            Manager manager = (Manager)rmtReg.lookup("manager");
            Store store = (Store)rmtReg.lookup("store");
            
            //instantiate UI object
            PostUI ui = new PostUI(manager, store);
            //run UI
            ui.run();
            
        } catch (RemoteException ex) {
            Logger.getLogger(PostUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(PostUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
