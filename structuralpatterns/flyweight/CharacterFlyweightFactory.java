package structuralpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory for creating and managing character styles.
 */
public class CharacterFlyweightFactory {
    private final Map<String, CharacterFlyweight> flyweights = new HashMap<>();

    public CharacterFlyweight getFlyweight(String font, int size, String color) {
        String key = font + size + color;
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new CharacterStyle(font, size, color));
        }
        return flyweights.get(key);
    }
}
