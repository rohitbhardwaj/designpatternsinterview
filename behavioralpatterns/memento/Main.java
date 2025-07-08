package behavioralpatterns.memento;

public class Main {
    public static void main(String[] args) {
        // Originator
        TextEditor editor = new TextEditor();

        // Caretaker
        History history = new History();

        // Initial state
        editor.setContent("Version 1");
        System.out.println("Current Content: " + editor.getContent());
        history.save(editor.save()); // Save state

        // Change state
        editor.setContent("Version 2");
        System.out.println("Current Content: " + editor.getContent());
        history.save(editor.save()); // Save state

        // Change state again
        editor.setContent("Version 3");
        System.out.println("Current Content: " + editor.getContent());

        // Undo
        editor.restore(history.undo());
        System.out.println("After Undo: " + editor.getContent());

        // Undo again
        editor.restore(history.undo());
        System.out.println("After Undo: " + editor.getContent());
    }
}