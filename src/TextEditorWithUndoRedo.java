import java.util.Stack;

public class TextEditorWithUndoRedo {

    static Stack<String> undoStack = new Stack<>();
    static Stack<String> redoStack = new Stack<>();

    static String text = "";

    static final int limit = 10;

    public static void main(String[] args) {

        type("hi");
        display();

        type("hello");
        display();

        type("C");
        display();

        undo();
        display();

        undo();
        display();

        redo();
        display();

        type("D");
        display();

        redo();
        display();
    }

    public static void type(String newText) {

        if (undoStack.size() == limit) {
            undoStack.remove(0);
        }

        undoStack.push(text);
        text += newText;

        redoStack.clear();
    }

    public static void undo() {

        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }

        redoStack.push(text);
        text = undoStack.pop();
    }

    public static void redo() {

        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }

        undoStack.push(text);
        text = redoStack.pop();
    }

    public static void display() {
        System.out.println("Current Text: " + text);
        System.out.println("Undo Stack: " + undoStack);
        System.out.println("Redo Stack: " + redoStack);
    }
}