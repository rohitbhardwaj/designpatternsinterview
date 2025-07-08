package structuralpatterns.decorator;

/**
 * Abstract Decorator implementing the UIComponent interface.
 */
public abstract class ComponentDecorator implements UIComponent {
    protected final UIComponent component;

    public ComponentDecorator(UIComponent component) {
        this.component = component;
    }

    @Override
    public void render() {
        component.render(); // Delegate rendering to the wrapped component
    }
}