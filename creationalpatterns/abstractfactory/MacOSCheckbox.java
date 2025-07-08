package creationalpatterns.abstractfactory;

// Concrete Product: MacOS Checkbox
public class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a MacOS checkbox.");
    }
}