import java.util.*;
public class LetterCombinationsOfANumbers {
    public static final String[] MAP = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }
    private static void backtrack(String digits, int idx, StringBuilder path, List<String> ans) {
        if (idx == digits.length()) {
            ans.add(path.toString());
            return;
        }
        String letters = MAP[digits.charAt(idx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits, idx + 1, path, ans);
            path.deleteCharAt(path.length() - 1); // undo
        }
    }
    public static void main(String[] args) {
       String digits = "23";
       System.out.println(letterCombinations(digits));
    }
}
