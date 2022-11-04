package mainB;

public class WoodenStructureAdapter {
    private WoodenStructures woodenStructures;

    public WoodenStructureAdapter(WoodenStructures wh) {
        woodenStructures = wh;
    }

    public void makeNoise() {
        woodenStructures.roll();
    }
}
