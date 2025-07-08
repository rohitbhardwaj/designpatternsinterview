package creationalpatterns.builder;

public class Main {
    public static void main(String[] args) {
        // Create a builder
        House.Builder builder = new House.Builder();

        // Build a basic house without a director
        House basicHouse = builder
                .setFoundation("Concrete Foundation")
                .setWalls("Brick Walls")
                .setRoof("Tile Roof")
                .build();
        System.out.println("Basic House:");
        System.out.println("Foundation: " + basicHouse.getFoundation());
        System.out.println("Walls: " + basicHouse.getWalls());
        System.out.println("Roof: " + basicHouse.getRoof());

        // Use the director to build a luxury house
        HouseDirector director = new HouseDirector(new House.Builder());
        House luxuryHouse = director.constructLuxuryHouse();
        System.out.println("\nLuxury House:");
        System.out.println("Foundation: " + luxuryHouse.getFoundation());
        System.out.println("Walls: " + luxuryHouse.getWalls());
        System.out.println("Roof: " + luxuryHouse.getRoof());
        System.out.println("Interior: " + luxuryHouse.getInterior());
    }
}
