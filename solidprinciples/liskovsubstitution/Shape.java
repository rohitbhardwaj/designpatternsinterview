package solidprinciples.liskovsubstitution;

/**
 * Base class representing a geometric shape.
 */
public class Shape {
    /**
     * Calculates the area of the shape.
     * 
     * @return the area of the shape as a double.
     */
    public double getArea() {
        return 0.0; // Default implementation, meant to be overridden
    }
}