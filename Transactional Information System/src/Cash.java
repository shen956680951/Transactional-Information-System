
public class Cash extends Payment {
    private double cashTendered;

    public Cash(double cashTendered) {
        this.cashTendered = cashTendered;
    }

    public boolean authorized() {
        System.out.println("Payment is authorized by Cash.");
        return true;
    }
}
