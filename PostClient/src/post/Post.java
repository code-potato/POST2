package post;

import java.util.ArrayList;
import serverInterfaces.*;
import serverSharedClasses.Item;
import serverSharedClasses.TransactionRecord;

/**
 * Post's main responsibility is to perform the transaction. This includes 1)
 * making sure an item exists, 2)calculating the total, 3)processing payment,
 * 4)saving transactionRecord, and 5)printing the invoice.
 *
 * @author Michael Santer
 */
public class Post {

    private Store store;
    private Invoice invoice;

    public Post(Store store) {
        this.store = store;
    }

    public TransactionRecord transact(TransactionRecord transaction) throws Exception {
        double total = 0.;
        ArrayList<Item> items = transaction.getItems();

        //1. make sure items exist in catalog
        for (Item item : items) {
            if (!store.hasProduct(item.getUPC())) {
                throw new Exception("UPC not found!");
            }

            //2. calculate total
            total += (store.getProduct(item.getUPC()).getPrice()) * item.getQuantity();
        }

        //3. process payment
        double amount = transaction.getPayment().processPayment(total);

        //4. print invoice
        invoice = new Invoice(transaction, total, store);
        invoice.setAmountReturned(amount);
        invoice.print();

        //5. save transactionRecord to store's transactionHistory
        return transaction;

    }

    /**
     * Get the total of current transaction.
     */
    public double getTotal(TransactionRecord transaction) throws Exception {
        double total = 0.;
        ArrayList<Item> items = transaction.getItems();

        //1. make sure items exist in catalog
        for (Item item : items) {
            if (!store.hasProduct(item.getUPC())) {
                throw new Exception("UPC not found!");
            }

            //2. calculate total
            total += (store.getProduct(item.getUPC()).getPrice()) * item.getQuantity();
        }

        return total;
    }

    @Override
    public String toString() {
        return invoice.printToScreen();

    }
}
