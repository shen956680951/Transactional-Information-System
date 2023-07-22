public class PurchaseOrder {
    private String orderID;
    private String customerID;
    private String orderDate;
    private String status;
    private double totalPrice;
    private double tax;
    private double shippingCost;

    public PurchaseOrder(String orderID, String customerID, String orderDate, String status, double totalPrice, double tax, double shippingCost) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.status = status;
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.shippingCost = shippingCost;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTax() {
        return tax;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    // add setters if needed...
}
