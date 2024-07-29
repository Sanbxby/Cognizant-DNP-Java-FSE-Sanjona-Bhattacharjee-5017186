interface PaymentStrategy {
    void pay(double amount);
}


class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card [" + cardHolderName + ", " + cardNumber + "]");
    }
}


class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal [" + email + "]");
    }
}


class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy selected");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}


public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        
        PaymentStrategy creditCardPayment = new CreditCardPayment("6289-4336-1911", "Christopher Nolan");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(1689);
        System.out.println();


        PaymentStrategy payPalPayment = new PayPalPayment("Nolan@oogle.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(7500);
    }
}
