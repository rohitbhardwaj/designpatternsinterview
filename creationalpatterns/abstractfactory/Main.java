package creationalpatterns.abstractfactory;

public class Main {
    public static void main(String[] args) {
        // Simulate selecting a platform (e.g., Windows or MacOS)
        String os = "Windows"; // Could be dynamically determined

        GUIFactory factory;

        if ("Windows".equalsIgnoreCase(os)) {
            factory = new WindowsFactory();
        } else if ("MacOS".equalsIgnoreCase(os)) {
            factory = new MacOSFactory();
        } else {
            throw new IllegalArgumentException("Unsupported OS: " + os);
        }

        // Create an application and render the UI
        Application app = new Application(factory);
        app.renderUI();
    }
}
