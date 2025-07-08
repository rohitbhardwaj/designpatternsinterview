package solidprinciples.liskovsubstitution.Composition;

/**
 * Square class using composition instead of inheritance.
 */
public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side; // Area of a square
    }

    // Getters and setters
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}