import java.util.Random;
import java.util.Scanner;

public class OrderSystem {
    private Warehouse warehouse;
    private Accounting accounting;
    private Purchasing purchasing;
    private Customer customer;
    private Scanner scanner;
    private Random random;

    public OrderSystem() {
        warehouse = new Warehouse();
        accounting = new Accounting();
        purchasing = new Purchasing();
        customer = new Customer();
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void start() {
        System.out.println("Welcome to the order system! Please input 'register' or 'login' to start:");
        String operation = scanner.nextLine();
        while (true) {
            switch (operation) {
                case "register":
                    System.out.println("Please input customer ID to register:");
                    String registerID = scanner.nextLine();
                    System.out.println("Please input customer name to register:");
                    String registerName = scanner.nextLine();
                    customer.register(registerID, registerName);
                    System.out.println("Please input 'register' or 'login' to start:");
                    break;
                case "login":
                    System.out.println("Please input customer ID to login:");
                    String loginID = scanner.nextLine();
                    if (customer.login(loginID)) {
                        customerOperation();
                    }
                    System.out.println("Please input 'register' or 'login' to start:");
                    break;
                default:
                    System.out.println("Invalid operation, please input 'register' or 'login' to start:");
            }
            operation = scanner.nextLine();
        }
    }

    private void customerOperation() {
        String operation;
        do {
            System.out.println("Please input operation: 'viewProducts', 'placeOrder', 'makePayment', or 'exit':");
            operation = scanner.nextLine();
            switch (operation) {
                case "viewProducts":
                    customer.viewProducts(warehouse);
                    break;
                case "placeOrder":
                    System.out.println("Please input order date:");
                    String orderDate = scanner.nextLine();
                    System.out.println("Please input product ID to place order:");
                    String productID = scanner.nextLine();
                    Product product = warehouse.findProductByID(productID);
                    if (product == null) {
                        System.out.println("Invalid product ID!");
                        break;
                    }
                    if (product.getStockSituation() <= 0) {
                        System.out.println("The product is out of stock!");
                        break;
                    }
                    product.decrementStock();
                    String orderID = String.format("%011d", random.nextInt(1000000000));
                    double tax = 0.10; // Assume a tax rate of 10%
                    double shippingCost = 5.0; // Assume a fixed shipping cost
                    PurchaseOrder order = customer.placeOrder(purchasing, orderID, orderDate, "Processing", product.getPrice(), tax, shippingCost);
                    System.out.println("Order has been placed successfully. Your order ID is: " + orderID);
                    break;
                case "makePayment":
                    System.out.println("Please input order ID to make payment:");
                    String paymentOrderID = scanner.nextLine();
                    System.out.println("Please input payment type (cash or credit):");
                    String paymentType = scanner.nextLine();
                    PurchaseOrder paymentOrder = purchasing.retrieveOrder(paymentOrderID);
                    if (paymentOrder == null) {
                        System.out.println("Invalid order ID!");
                        break;
                    }
                    customer.makePayment(accounting, paymentOrderID, paymentOrder.getTotalPrice(), paymentOrder.getTax(), paymentOrder.getShippingCost(), paymentType);
                    break;
                case "exit":
                    System.out.println("You have logged out.");
                    break;
                default:
                    System.out.println("Invalid operation!");
            }
        } while (!operation.equals("exit"));
    }

    public static void main(String[] args) {
        OrderSystem orderSystem = new OrderSystem();
        orderSystem.start();
    }
}


