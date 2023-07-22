import java.util.HashMap;

public class Customer {
    private String customerID;
    private String customerName;
    private HashMap<String, String> customers = new HashMap<>();

    public Customer() {
        // Add two customers for initial data
        customers.put("300169700", "Hawk Shen");
        customers.put("300049389", "Chen Wang");
    }

    public boolean register(String customerID, String customerName) {
        if (customers.containsKey(customerID)) {
            System.out.println("This customer ID is already registered.");
            return false;
        } else {
            customers.put(customerID, customerName);
            System.out.println("Registration successful for customer ID: " + customerID);
            return true;
        }
    }

    public boolean login(String customerID) {
        if (customers.containsKey(customerID)) {
            this.customerID = customerID;
            this.customerName = customers.get(customerID);
            System.out.println("Login successful for customer ID: " + customerID);
            return true;
        } else {
            System.out.println("This customer ID is not registered.");
            return false;
        }
    }

    public void viewProducts(Warehouse warehouse) {
        warehouse.checkStock();
    }

    public PurchaseOrder placeOrder(Purchasing purchasing, String orderID, String orderDate, String status, double totalPrice, double tax, double shippingCost) {
        return purchasing.createOrder(orderID, this.customerID, orderDate, status, totalPrice, tax, shippingCost);
    }

    public void makePayment(Accounting accounting, String orderID, double totalPrice, double tax, double shippingCost, String paymentType) {
        if (paymentType.equals("cash")) {
            Cash cash = new Cash(totalPrice);
            accounting.calculatePrice(orderID, totalPrice, tax, shippingCost, cash);
        } else if (paymentType.equals("credit")) {
            Credit credit = new Credit("1234567890123456", "credit");
            if (credit.authorized()) {
                accounting.calculatePrice(orderID, totalPrice, tax, shippingCost, credit);
            }
        }
    }
}
