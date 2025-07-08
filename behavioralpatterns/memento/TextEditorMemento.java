package behavioralpatterns.memento;

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