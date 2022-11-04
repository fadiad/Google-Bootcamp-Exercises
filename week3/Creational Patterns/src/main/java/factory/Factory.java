package factory;


public class Factory {

    private static Factory instance;

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    private Factory() {

    }


    public Vehicle creatVehicale(Vehicles type) {
        switch (type) {
            case PLANE:
                return new Plane();
            case BUS:
                return new Bus();
            case TAXI:
                return new Taxi();
            case BOAT:
                return new Boat();
            default:
                throw new IllegalArgumentException(String.format("Vehicle type not supported: %s", type));
        }
    }
}
