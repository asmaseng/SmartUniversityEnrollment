public class CardPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " made by bank card.");
    }
}