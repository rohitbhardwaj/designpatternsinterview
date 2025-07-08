package behavioralpatterns.memento;

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



