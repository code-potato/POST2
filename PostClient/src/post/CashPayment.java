package post;

/**
 * CashPayment defines how cash payments are processed. 
 * @author Michael Santer
 */
class CashPayment extends PaymentImpl {

    public CashPayment() {
    }

    @Override
    public double processPayment(double total) {
        return this.getAmount() - total;
    }
    
}
