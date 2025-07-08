package behavioralpatterns.memento;

import java.util.Stack;

/**
 * Caretaker class that manages mementos.
 */
public class History {
    private final Stack<TextEditorMemento> mementos = new Stack<>();

    public void save(TextEditorMemento memento) {
        mementos.push(memento);
    }

    public TextEditorMemento undo() {
        if (!mementos.isEmpty()) {
            return mementos.pop();
        }
        return null;
    }
}
