package structuralpatterns.flyweight;

public class Main {
    public static void main(String[] args) {
        // Create the Flyweight Factory
        CharacterFlyweightFactory factory = new CharacterFlyweightFactory();

        // Use shared character styles
        CharacterFlyweight style1 = factory.getFlyweight("Arial", 12, "Black");
        CharacterFlyweight style2 = factory.getFlyweight("Times New Roman", 14, "Blue");

        // Display characters with extrinsic state
        style1.display(new CharacterExtrinsicState('A', 10, 20));
        style1.display(new CharacterExtrinsicState('B', 15, 25));
        style2.display(new CharacterExtrinsicState('C', 30, 40));
    }
}