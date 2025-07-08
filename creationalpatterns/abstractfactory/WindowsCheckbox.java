package creationalpatterns.abstractfactory;

// Concrete Product: Windows Checkbox
public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows checkbox.");
    }
}