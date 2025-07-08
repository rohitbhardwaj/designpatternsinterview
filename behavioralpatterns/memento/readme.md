Behavioral Design Patterns: Memento Pattern
Objective
The Memento Design Pattern captures and restores an object’s state without violating encapsulation. It is used to provide undo functionality, state snapshotting, or rollback capabilities.

What is the Memento Pattern?
The Memento Pattern allows an object to save its state to a memento object and later restore its state from that memento. This enables features like undo/redo, state rollback, and checkpoints.

Key Components
Originator:

The object whose state needs to be saved and restored.
Creates mementos to save its state and uses them to restore its state.
Memento:

Stores the state of the Originator.
Does not allow external modification to ensure encapsulation.
Caretaker:

Manages mementos by storing and retrieving them as needed.
Does not inspect or modify the stored state.
Client:

Initiates save and restore operations using the Caretaker and Originator.
When to Use the Memento Pattern
Undo Functionality:

When users need to revert changes made to an object’s state.
Snapshotting:

When you need to save the state of an object at various points for features like versioning or checkpoints.
Transaction Rollback:

When you need to rollback changes in case of errors or exceptions (e.g., database transactions).
Caching:

When caching the state of an object can improve performance.
When Not to Use the Memento Pattern
Large Object State:

If the object’s state is too large, managing snapshots can become resource-intensive.
Frequent State Changes:

If state changes frequently, managing snapshots may lead to inefficiency.
Immutable Objects:

If the state is immutable or easily reconstructible, using the pattern may be unnecessary.
Overhead:

Avoid when undo/redo or rollback functionality is not required, as the pattern adds complexity.
Implementation
Use Case:
A text editor that allows users to undo changes to their text.

1. Originator
The originator holds the state and creates mementos:

java
Copy code
/**
 * Originator class that manages the state.
 */
public class TextEditor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    /**
     * Saves the current state to a memento.
     */
    public TextEditorMemento save() {
        return new TextEditorMemento(content);
    }

    /**
     * Restores the state from a memento.
     */
    public void restore(TextEditorMemento memento) {
        this.content = memento.getContent();
    }
}
2. Memento
The memento stores the state:

java
Copy code
/**
 * Memento class for storing the state of the TextEditor.
 */
public class TextEditorMemento {
    private final String content;

    public TextEditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
3. Caretaker
The caretaker manages the history of mementos:

java
Copy code
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
4. Client
The client interacts with the system to save and restore states:

java
Copy code
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
Output
plaintext
Copy code
Current Content: Version 1
Current Content: Version 2
Current Content: Version 3
After Undo: Version 2
After Undo: Version 1
Benefits of the Memento Pattern
Encapsulation:

Preserves encapsulation by not exposing internal state to the caretaker.
Undo/Redo Functionality:

Provides a simple way to implement undo and redo features.
State Management:

Supports checkpointing and rollback features.
Separation of Concerns:

Separates state-saving logic (memento) from state-management logic (originator).
Challenges
Memory Overhead:

Saving multiple snapshots can consume significant memory.
Complexity:

Adds additional classes and logic, which may not be necessary for simple use cases.
Limited Scope:

Best suited for applications with clear undo/redo requirements.
Real-World Applications
Text Editors:

Save text states for undo/redo functionality.
Games:

Save game progress as checkpoints.
Transactional Systems:

Rollback to previous states in case of errors.
Version Control:

Manage multiple states or versions of files.
Key Takeaways
The Memento Pattern is ideal for saving and restoring object states, enabling undo/redo and checkpointing.
It balances encapsulation and functionality, ensuring internal state remains hidden.
While useful, the pattern should be applied judiciously to avoid unnecessary memory overhead and complexity.