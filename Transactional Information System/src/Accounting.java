import java.util.HashMap;
import java.util.Map;

public class Accounting {
    private Map<String, PurchaseOrder> processedOrders;

    public Accounting() {
        this.processedOrders = new HashMap<>();
    }

    public void calculatePrice(String orderID, double totalPrice, double tax, double shippingCost, Payment payment) {
        double finalPrice = totalPrice * (1 + tax) + shippingCost;
        System.out.println("The final price for order " + orderID + " is: " + finalPrice);
        payment.authorized();
    }

    public void printReceipt(PurchaseOrder order) {
        System.out.println("Receipt for order " + order.getOrderID() + ":");
        System.out.println("Total price: " + order.getTotalPrice());
        System.out.println("Tax: " + order.getTax());
        System.out.println("Shipping cost: " + order.getShippingCost());
        System.out.println("Final price: " + (order.getTotalPrice() + order.getTax() + order.getShippingCost()));
    }

    public void processPayment(PurchaseOrder order) {
        this.processedOrders.put(order.getOrderID(), order);
    }

    public PurchaseOrder retrieveOrder(String orderID) {
        return this.processedOrders.get(orderID);
    }
}
