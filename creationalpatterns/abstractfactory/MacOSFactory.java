package creationalpatterns.abstractfactory;

// Concrete Factory: MacOS Factory
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton(); // Create a MacOS Button
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox(); // Create a MacOS Checkbox
    }
}