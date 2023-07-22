import java.util.HashMap;
import java.util.Map;

public class Purchasing {
    private Map<String, PurchaseOrder> orders;

    public Purchasing() {
        this.orders = new HashMap<>();
    }

    public PurchaseOrder createOrder(String orderID, String customerID, String orderDate, String status, double totalPrice, double tax, double shippingCost) {
        PurchaseOrder order = new PurchaseOrder(orderID, customerID, orderDate, status, totalPrice, tax, shippingCost);
        this.orders.put(orderID, order);
        return order;
    }

    public PurchaseOrder retrieveOrder(String orderID) {
        return this.orders.get(orderID);
    }
}
