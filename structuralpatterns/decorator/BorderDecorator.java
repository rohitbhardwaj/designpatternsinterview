package structuralpatterns.decorator;

/**
 * Concrete Decorator to add a border to the UI component.
 */
public class BorderDecorator extends ComponentDecorator {
    public BorderDecorator(UIComponent component) {
        super(component);
    }

    @Override
    public void render() {
        super.render(); // Render the base component
        addBorder();    // Add border functionality
    }

    private void addBorder() {
        System.out.println("Adding border to the component.");
    }
}