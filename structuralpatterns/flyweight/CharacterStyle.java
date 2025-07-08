package structuralpatterns.flyweight;

/**
 * Concrete Flyweight representing a character with shared style.
 */
public class CharacterStyle implements CharacterFlyweight {
    private final String font;
    private final int size;
    private final String color;

    public CharacterStyle(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    @Override
    public void display(CharacterExtrinsicState extrinsicState) {
        System.out.println("Character: " + extrinsicState.getCharacter() +
                ", Font: " + font +
                ", Size: " + size +
                ", Color: " + color +
                ", Position: (" + extrinsicState.getX() + ", " + extrinsicState.getY() + ")");
    }
}