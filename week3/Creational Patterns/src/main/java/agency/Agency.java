package agency;

import factory.Factory;
import factory.Passenger;
import factory.Vehicle;
import factory.Vehicles;

import java.util.HashMap;
import java.util.Map;

public class Agency {
    private Map<Vehicles, Integer> agencyVehicales;

    private Factory factory;
    private int taxies;
    private int buses;
    private int boats;
    private int plans;

    public Agency() {
        taxies = 8;
        buses = 4;
        boats = 3;
        plans = 1;

        agencyVehicales = new HashMap<>();

        factory = Factory.getInstance();

        agencyVehicales.put(Vehicles.BUS, 4);
        agencyVehicales.put(Vehicles.TAXI, 8);
        agencyVehicales.put(Vehicles.BOAT, 3);
        agencyVehicales.put(Vehicles.PLANE, 1);

    }

    public Vehicle giveServies(Passenger passenger) {
        if (agencyVehicales.get(passenger.getFavoriteVehicle()) > 0) {
            agencyVehicales.put(passenger.getFavoriteVehicle(), agencyVehicales.get(passenger.getFavoriteVehicle()) - 1);
            return factory.creatVehicale(passenger.getFavoriteVehicle());
        }

        return choseRandomVehical();
    }


    private Vehicle choseRandomVehical() {
        for (Vehicles vehicle : agencyVehicales.keySet()) {
            if (agencyVehicales.get(vehicle) > 0) {
                agencyVehicales.put(vehicle, agencyVehicales.get(vehicle) - 1);
                return factory.creatVehicale(vehicle);
            }
        }
        return null;
    }

}
