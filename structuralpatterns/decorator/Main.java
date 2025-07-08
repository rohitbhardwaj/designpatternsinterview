package structuralpatterns.decorator;

public class Main {
    public static void main(String[] args) {
        // Create a basic TextView
        UIComponent textView = new TextView();

        // Decorate the TextView with a border
        UIComponent borderedTextView = new BorderDecorator(textView);

        // Decorate the bordered TextView with a shadow
        UIComponent borderedShadowedTextView = new ShadowDecorator(borderedTextView);

        // Render the components
        System.out.println("Rendering basic TextView:");
        textView.render();

        System.out.println("\nRendering TextView with Border:");
        borderedTextView.render();

        System.out.println("\nRendering TextView with Border and Shadow:");
        borderedShadowedTextView.render();
    }
}