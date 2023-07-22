public class Product {
    private String productID;
    private String name;
    private double price;
    private int stockSituation;

    public Product(String productID, String name, double price, int stockSituation) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.stockSituation = stockSituation;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockSituation() {
        return stockSituation;
    }

    public void decrementStock() {
        if (stockSituation > 0) {
            stockSituation--;
        } else {
            throw new RuntimeException("No stock left for product: " + this.productID);
        }
    }
}

