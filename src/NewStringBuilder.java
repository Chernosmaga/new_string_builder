import java.util.Arrays;
import java.util.Objects;

public class NewStringBuilder {
    private char[] letters;
    private final State state = new State();

    public NewStringBuilder(String string) {
        letters = string.toCharArray();
        state.saveState(letters);
    }

    public String append(String string) {
        char[] newLetters = new char[letters.length + string.length()];
        char[] newString = string.toCharArray();
        int count = 0;
        for (int i = 0; i < letters.length + string.length(); i++) {
            if (i <= letters.length - 1) {
                newLetters[i] = letters[i];
            } else {
                newLetters[i] = newString[count];
                count++;
            }
        }
        letters = newLetters;
        state.saveState(letters);
        return Arrays.toString(letters);
    }

    public String delete(int start, int end) {
        char[] newLetters = new char[letters.length - (end - start)];
        for (int i = 0; i < newLetters.length; i++) {
            newLetters[i] = letters[i];
        }
        letters = newLetters;
        state.saveState(letters);
        return Arrays.toString(letters);
    }

    public String deleteCharAt(int index) {
        char[] newLetters = new char[letters.length - 1];
        for (int i = 0; i < letters.length; i++) {
            if (i != index) {
                newLetters[i] = letters[i];
            }
        }
        letters = newLetters;
        state.saveState(letters);
        return Arrays.toString(letters);
    }

    public String replace(int start, String string) {
        char[] newLetters = new char[letters.length];
        char[] newString = string.toCharArray();
        for (int i = 0; i < newLetters.length; i++) {
            if (i == start) {
                for (int j = 0; j < string.length(); j++) {
                    newLetters[i] = newString[j];
                    i++;
                }
                i--;
            } else {
                newLetters[i] = letters[i];
            }
        }
        letters = newLetters;
        state.saveState(letters);
        return Arrays.toString(letters);
    }

    public void undo() {
        letters = state.getState();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewStringBuilder that)) return false;
        return Arrays.equals(letters, that.letters) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(state);
        result = 31 * result + Arrays.hashCode(letters);
        return result;
    }

    @Override
    public String toString() {
        return "NewStringBuilder{" +
                "letters=" + Arrays.toString(letters) +
                '}';
    }
}
