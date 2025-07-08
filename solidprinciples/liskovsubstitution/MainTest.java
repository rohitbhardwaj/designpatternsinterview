package solidprinciples.liskovsubstitution;


public class MainTest {
    public static void main(String[] args) {
        // Using a rectangle
        Rectangle rectangle = new Rectangle(5, 10);
        rectangle.setWidth(7); // Expected: Changes only the width
        System.out.println("Rectangle Area: " + rectangle.getArea()); // Correct: 7 * 10 = 70

        // Using a square in place of a rectangle
        Rectangle square = new Square(5);
        square.setWidth(7); // Changes both width and height
        System.out.println("Square Area: " + square.getArea()); // Incorrect: Should be 7 * 5 = 35, but changes to 7 * 7
    }
}
