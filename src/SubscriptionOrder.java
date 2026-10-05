public class SubscriptionOrder extends Order {

    public SubscriptionOrder(PaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void processOrder(double amount) {
        System.out.println("Processing subscription order...");
        paymentProcessor.pay(amount);
    }
}