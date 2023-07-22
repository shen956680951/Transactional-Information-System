
public class Credit extends Payment {
    private String number;
    private String type;

    public Credit(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public boolean authorized() {
        if (number.length() == 16 && type.equals("credit")) {
            System.out.println("Payment is authorized by Credit.");
            return true;
        } else {
            System.out.println("Invalid Credit.");
            return false;
        }
    }
}
