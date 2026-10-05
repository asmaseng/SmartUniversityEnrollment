public class Main {

    public static void main(String[] args) {

        PaymentProcessor cardPayment = new CardPayment();
        PaymentProcessor kaspiPayment = new KaspiPayment();

        System.out.println("=== Online Order with Card ===");
        Order onlineOrder = new OnlineOrder(cardPayment);
        onlineOrder.processOrder(50000);

        System.out.println();

        System.out.println("=== Subscription Order with Kaspi ===");
        Order subscriptionOrder = new SubscriptionOrder(kaspiPayment);
        subscriptionOrder.processOrder(15000);

        System.out.println();

        System.out.println("=== Online Order with Kaspi ===");
        Order anotherOnlineOrder = new OnlineOrder(kaspiPayment);
        anotherOnlineOrder.processOrder(75000);
    }
}