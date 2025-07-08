package structuralpatterns.flyweight;

/**
 * Extrinsic state representing character-specific information.
 */
public class CharacterExtrinsicState {
    private final char character;
    private final int x;
    private final int y;

    public CharacterExtrinsicState(char character, int x, int y) {
        this.character = character;
        this.x = x;
        this.y = y;
    }

    public char getCharacter() {
        return character;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
