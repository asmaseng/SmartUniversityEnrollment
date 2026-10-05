public class KaspiPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " made using Kaspi.");
    }
}