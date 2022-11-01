package factory;

public class Bus implements Vehicle {
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName());
    }
}
