package creationalpatterns.abstractfactory;

// Concrete Product: MacOS Button
public class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a MacOS button.");
    }
}