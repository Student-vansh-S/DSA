import java.util.*;
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        getAllParts(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    public static void getAllParts(String s, int start, List<String> path, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));  
                getAllParts(s, end + 1, path, ans);     
                path.remove(path.size() - 1);           
            }
        }
    }
    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)){ 
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="aab";
        System.out.println(partition(s));
    }
}
