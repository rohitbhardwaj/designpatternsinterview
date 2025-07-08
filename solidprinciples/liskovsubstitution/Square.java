package solidprinciples.liskovsubstitution;

/**
 * Square class extending Rectangle, introducing an LSP violation.
 */
public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width); // Ensure width and height are the same
    }

    @Override
    public void setHeight(double height) {
        super.setWidth(height);
        super.setHeight(height); // Ensure width and height are the same
    }
}

/*
 * Behavioral Change:

Square changes the behavior of setWidth and setHeight in Rectangle.
When setWidth or setHeight is called on a Square, it modifies both dimensions to ensure it remains a square, which violates the expected behavior of a rectangle.
Substitutability Issue:

If a Square object is used in place of a Rectangle, the behavior is inconsistent with the base class’s contract.
 * 
 */