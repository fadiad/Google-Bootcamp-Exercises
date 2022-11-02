package mainB.Visitor;

public class Asset implements Appliance{

    private int serialNumber;
    private String owner;
    private double rating;

    public Asset(int serialNumber, String owner, double rating) {
        this.serialNumber = serialNumber;
        this.owner = owner;
        this.rating = rating;
    }


    @Override
    public void accept(Visitor visitor) {

    }
}
