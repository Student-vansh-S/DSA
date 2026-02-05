import java.util.*;
public class LongestSubStringWithoutRepeating {
    public static int longestSubString(String s){
        Map<Character, Integer> last = new HashMap<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (last.containsKey(ch) && last.get(ch) >= left) {
                left = last.get(ch) + 1;
            }
            last.put(ch, right);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
    public static void main(String[] args) {
        System.out.println(longestSubString("abcabcbb")); // 3 ("abc")
        System.out.println(longestSubString("bbbbb"));    // 1 ("b")
        System.out.println(longestSubString("pwwkew"));   // 3 ("wke")
    }
}
