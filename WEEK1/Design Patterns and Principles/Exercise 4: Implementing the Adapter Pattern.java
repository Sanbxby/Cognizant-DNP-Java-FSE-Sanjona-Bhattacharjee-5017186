public class AdapterPatternExample {

    
    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    
    public static class Paytm {
        public void initiateTransaction(double amount) {
            System.out.println("Processing Paytm payment of Rs" + amount);
        }
    }


    public static class PhonePe {
        public void startPayment(double amount) {
            System.out.println("Processing PhonePe payment of Rs" + amount);
        }
    }


    public static class PayPal {
        public void executePayment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }

    
    public static class GooglePay {
        public void performTransaction(double amount) {
            System.out.println("Processing Google Pay payment of Rs" + amount);
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


    public static class PhonePeAdapter implements PaymentProcessor {
        private PhonePe phonePe;

        public PhonePeAdapter(PhonePe phonePe) {
            this.phonePe = phonePe;
        }

        @Override
        public void processPayment(double amount) {
            phonePe.startPayment(amount);
        }
    }


    public static class PayPalAdapter implements PaymentProcessor {
        private PayPal payPal;

        public PayPalAdapter(PayPal payPal) {
            this.payPal = payPal;
        }

        @Override
        public void processPayment(double amount) {
            payPal.executePayment(amount);
        }
    }

    public static class GooglePayAdapter implements PaymentProcessor {
        private GooglePay googlePay;

        public GooglePayAdapter(GooglePay googlePay) {
            this.googlePay = googlePay;
        }

        @Override
        public void processPayment(double amount) {
            googlePay.performTransaction(amount);
        }
    }

    public static void main(String[] args) {
        
        PaymentProcessor paytmProcessor = new PaytmAdapter(new Paytm());
        PaymentProcessor phonePeProcessor = new PhonePeAdapter(new PhonePe());
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor googlePayProcessor = new GooglePayAdapter(new GooglePay());

        
        paytmProcessor.processPayment(7713.0);
        phonePeProcessor.processPayment(1234.0);
        payPalProcessor.processPayment(56.78);
        googlePayProcessor.processPayment(910.11);
    }
}
