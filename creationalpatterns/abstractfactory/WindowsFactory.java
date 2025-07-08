package creationalpatterns.abstractfactory;

// Concrete Factory: Windows Factory
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton(); // Create a Windows Button
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox(); // Create a Windows Checkbox
    }
}
