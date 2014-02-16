package post;

/**
 * CreditPayment defines how credit payments are processed.
 * @author Michael Santer
 */
class CreditPayment extends PaymentImpl {

    private int accountNumber;
    
    public CreditPayment() {
    }

    CreditPayment(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public double processPayment(double total) {
        return 0.;
    }    

    public int getAccountNumber() {
        return accountNumber;
    }
    
    
    
}
