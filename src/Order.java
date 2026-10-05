public abstract class Order {

    protected PaymentProcessor paymentProcessor;

    public Order(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public abstract void processOrder(double amount);
}