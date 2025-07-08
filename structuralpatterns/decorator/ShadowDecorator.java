package structuralpatterns.decorator;

/**
 * Concrete Decorator to add a shadow to the UI component.
 */
public class ShadowDecorator extends ComponentDecorator {
    public ShadowDecorator(UIComponent component) {
        super(component);
    }

    @Override
    public void render() {
        super.render(); // Render the base component
        addShadow();    // Add shadow functionality
    }

    private void addShadow() {
        System.out.println("Adding shadow to the component.");
    }
}