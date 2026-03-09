import java.util.Stack;
public class DuplicateParentheses {
    public static boolean duplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            // closing
            char ch = str.charAt(i);
            if (ch == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;
                }
            } else {
                // opening
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b))";
        String str1 = "(a+b)";
        System.out.println(duplicate(str));
        System.out.println(duplicate(str1));
    }
}
