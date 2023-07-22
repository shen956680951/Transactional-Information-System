import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Product> products = new ArrayList<>();

    public Warehouse() {
        products.add(new Product("000001", "Product 1", 19.99, 10));
        products.add(new Product("000002", "Product 2", 29.99, 20));
        products.add(new Product("000003", "Product 3", 39.99, 0));
        products.add(new Product("000004", "Product 4", 49.99, 15));
        products.add(new Product("000005", "Product 5", 59.99, 0));
        products.add(new Product("000006", "Product 6", 69.99, 25));
        products.add(new Product("000007", "Product 7", 79.99, 0));
        products.add(new Product("000008", "Product 8", 89.99, 30));
        products.add(new Product("000009", "Product 9", 99.99, 0));
        products.add(new Product("000010", "Product 10", 109.99, 35));
    }

    public void checkStock() {
        for (Product product : products) {
            System.out.println("ID: " + product.getProductID() + ", Name: " + product.getName() +
                    ", Price: " + product.getPrice() + ", Stock: " + product.getStockSituation());
        }
    }

    public Product findProductByID(String productID) {
        for (Product product : products) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        return null;
    }
}
