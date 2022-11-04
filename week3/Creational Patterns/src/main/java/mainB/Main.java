package mainB;

import agency.Agency;
import factory.Passenger;
import factory.Vehicles;

public class Main {
    public static void main(String[] args) {

        Agency agency = new Agency();
        Passenger passenger = new Passenger("yael", Vehicles.BOAT);

        try {
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);
            agency.giveServies(passenger).transport(passenger);


        } catch (NullPointerException n) {
            System.out.println("no available vehicles");
        }

    }
}
