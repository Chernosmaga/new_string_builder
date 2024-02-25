import java.util.Stack;

public class State {
    private final Stack<char[]> history = new Stack<>();

    public State() {}

    public void saveState(char[] chars) {
        history.push(chars);
    }

    public char[] getState() {
        history.pop();
        return history.pop();
    }
}
