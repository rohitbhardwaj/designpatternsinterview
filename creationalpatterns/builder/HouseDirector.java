package creationalpatterns.builder;

/**
 * Director class to manage the building process of a House.
 */
public class HouseDirector {
    private final House.Builder builder;

    public HouseDirector(House.Builder builder) {
        this.builder = builder;
    }

    // Construct a basic house
    public House constructBasicHouse() {
        return builder
                .setFoundation("Concrete Foundation")
                .setWalls("Wooden Walls")
                .setRoof("Shingle Roof")
                .build();
    }

    // Construct a luxury house
    public House constructLuxuryHouse() {
        return builder
                .setFoundation("Stone Foundation")
                .setWalls("Marble Walls")
                .setRoof("Slate Roof")
                .setInterior("Modern Interior")
                .build();
    }
}
