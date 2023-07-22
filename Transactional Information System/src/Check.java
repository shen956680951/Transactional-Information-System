
public class Check extends Payment {
    private String name;
    private String ID;

    public Check(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public boolean authorized() {
        System.out.println("Payment is authorized by Check.");
        return true;
    }
}
