import java.util.*;
public class LongestSubStringWithoutRepeating {
    public static int longestSubString(String s){
        // Approach 1 (HashMap)
        // Map<Character, Integer> temp = new HashMap<>();
        // int left = 0, result = 0;
        // for (int right = 0; right < s.length(); right++) {
        //     char ch = s.charAt(right);
        //     if (temp.containsKey(ch) && temp.get(ch) >= left) {
        //         left = temp.get(ch) + 1;
        //     }
        //     temp.put(ch, right);
        //     result = Math.max(result, right - left + 1);
        // }
        // return result;

        //Approach 2 (int Array of size 256(Extended ASCII)
        int[] temp = new int[256];
        Arrays.fill(temp, -1);
        int left = 0, result = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (ch < 256 && temp[ch] >= left) {
                left = temp[ch] + 1;
            }
            if (ch < 256) temp[ch] = right;
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(longestSubString("abcabcbb")); // 3 ("abc")
        System.out.println(longestSubString("bbbbb"));    // 1 ("b")
        System.out.println(longestSubString("pwwkew"));   // 3 ("wke")
    }
}
