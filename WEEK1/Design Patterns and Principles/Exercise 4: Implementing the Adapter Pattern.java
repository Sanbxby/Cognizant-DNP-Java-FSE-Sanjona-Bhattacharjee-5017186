

public class AdapterPatternExample {

    
    public interface PaymentProcessor {
        void processPayment(double amount);
    }


    public static class Paytm {
        public void initiateTransaction(double amount) {
            System.out.println("Processing Paytm payment of Rs" + amount);
        }
    }


    public static class PaytmAdapter implements PaymentProcessor {
        private Paytm paytm;

        public PaytmAdapter(Paytm paytm) {
            this.paytm = paytm;
        }

        @Override
        public void processPayment(double amount) {
            paytm.initiateTransaction(amount);
        }
    }

    public static void main(String[] args) {
        
        PaymentProcessor paytmProcessor = new PaytmAdapter(new Paytm());
        paytmProcessor.processPayment(7713.0);
    }
}
