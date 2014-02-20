package post;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import serverInterfaces.*;
import serverSharedClasses.*;

/**
 * Invoice handles how transactions are presented.
 *
 * @author Michael Santer
 */
public class Invoice {

    TransactionRecord transaction;
    Double total, amountReturned;
    Store store;

    public Invoice(TransactionRecord transaction, Store store) {
        this.transaction = transaction;
        this.store = store;
    }

    public Invoice(TransactionRecord transaction, double total, Store store) {
        this.transaction = transaction;
        this.store = store;
        this.total = total;
    }

    /**
     * Constructs the layout of a plain text invoice.
     *
     * @return String
     */
    public String toString() {
        String invoice = "";
        invoice += "______________________________________________________\n\n";
        try {
            invoice += store.getName() + "\n";
        } catch (RemoteException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        invoice += "______________________________________________________\n\n";

        invoice += String.format("%-25s %-20s\n", "Customer Name:", "Date & Time:");

        String customerName = transaction.getCustomerFirstName();
        if (transaction.getCustomerLastName() != null) {
            customerName += " " + transaction.getCustomerLastName();
        }

        invoice += String.format("%-25s %-20s\n\n", customerName,
                transaction.getDateAndTime());
        invoice += String.format("%-12s %-12s %-12s %-12s\n", "Item:", "QTY:",
                "Unit Price:", "Subtotal:");

        ArrayList<Item> items = transaction.getItems();
        for (Item item : items) {
            try {
                double price = store.getProduct(item.getUPC()).getPrice();
                invoice += String.format("%-12s %-12s $%-12.2f $%-12.2f\n",
                        store.getProduct(item.getUPC()).getDescription(),
                        item.getQuantity(), price, price * item.getQuantity());
            } catch (RemoteException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        invoice += "------------------------------------------------------\n";
        invoice += String.format("Total: $%.2f\n", total);

        if (transaction.getPayment() instanceof CashPayment) {
            invoice += "Amount Tendered: $"
                    + String.format("%.2f\n", transaction.getPayment().getAmount())
                    + "Amount Returned: $"
                    + String.format("%.2f\n", amountReturned);
        } else if (transaction.getPayment() instanceof CheckPayment) {
            invoice += "Paid by Check \n";
        } else { //if credit card
            CreditPayment credit = (CreditPayment) transaction.getPayment();
            invoice += "Paid by Credit Card " + credit.getAccountNumber() + "\n";
        }
        invoice += "\n******************************************************\n\n";
        return invoice;
    }

    /**
     * Prints invoice to terminal.
     */
    public void print() {
        System.out.println(this);
    }

    /**
     * Prints a transaction result to GUI screen.
     */
    public String printToScreen() {
        String invoice = "";
        invoice += "\n---------------------------------------------------------------------------------------------------------\n";

        if (transaction.getPayment() instanceof CashPayment) {
            invoice += "Amount Tendered: $"
                    + String.format("%.2f\n", transaction.getPayment().getAmount())
                    + "Amount Returned: $"
                    + String.format("%.2f\n", amountReturned);
        } else if (transaction.getPayment() instanceof CheckPayment) {
            invoice += "Paid by Check \n";
        } else { //if credit card
            CreditPayment credit = (CreditPayment) transaction.getPayment();
            invoice += "Paid by Credit Card " + credit.getAccountNumber() + "\n";
        }
        return invoice;
    }

    void setAmountReturned(double amount) {
        amountReturned = amount;
    }
}
