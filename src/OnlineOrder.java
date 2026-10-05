public class OnlineOrder extends Order {

    public OnlineOrder(PaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void processOrder(double amount) {
        System.out.println("Processing online order...");
        paymentProcessor.pay(amount);
    }
}