public class Main {
    public static void main(String[] args) {
        String string = "Hello, World!";
        NewStringBuilder stringBuilder = new NewStringBuilder(string);
        System.out.println(stringBuilder);
        stringBuilder.append("!!");
        System.out.println(stringBuilder);
        stringBuilder.undo();
        System.out.println(stringBuilder);
        stringBuilder.deleteCharAt(12);
        System.out.println(stringBuilder);
        stringBuilder.replace(0, "h");
        stringBuilder.replace(2, "LLO, w");
        System.out.println(stringBuilder);
        stringBuilder.delete(1, 11);
        System.out.println(stringBuilder);
        stringBuilder.undo();
        System.out.println(stringBuilder);
        stringBuilder.undo();
        System.out.println(stringBuilder);
    }
}