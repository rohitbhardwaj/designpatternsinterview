package structuralpatterns.decorator;

/**
 * Concrete Component representing a basic TextView.
 */
public class TextView implements UIComponent {
    @Override
    public void render() {
        System.out.println("Rendering TextView.");
    }
}