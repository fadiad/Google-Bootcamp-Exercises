package factory;

public class Passenger {
    private String name;
    private Vehicles favoriteVehicle;

    public Passenger(String name, Vehicles favoriteVehicle) {
        this.name = name;
        this.favoriteVehicle = favoriteVehicle;
    }

    public String getName() {
        return name;
    }

    public Vehicles getFavoriteVehicle() {
        return favoriteVehicle;
    }
}
