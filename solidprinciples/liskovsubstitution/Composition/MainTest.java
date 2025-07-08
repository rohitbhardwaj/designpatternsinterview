package solidprinciples.liskovsubstitution.Composition;


public class MainTest {
    public static void main(String[] args) {
        // Using a rectangle
        Shape rectangle = new Rectangle(5, 10);
        System.out.println("Rectangle Area: " + rectangle.getArea()); // 50

        // Using a square
        Shape square = new Square(5);
        System.out.println("Square Area: " + square.getArea()); // 25
    }
}
