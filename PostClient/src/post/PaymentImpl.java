package post;
import postInterfaces.*;
/**
 * Payment is an abstract class that defines the structure for other types of
 * payments. 
 * @author Michael Santer
 */
abstract class PaymentImpl implements Payment {
    private double amount;
    
    /**
     * Defines how a specific payment is processed. 
     * @param total
     * @return 
     */
    abstract public double processPayment(double total);

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    
    
}
