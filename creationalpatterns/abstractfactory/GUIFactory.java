package creationalpatterns.abstractfactory;

/**
 * Abstract factory for creating GUI components.
 */
public interface GUIFactory {
    Button createButton(); // Factory method to create a Button
    Checkbox createCheckbox(); // Factory method to create a Checkbox
}
