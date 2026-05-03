public class LongestSubStringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        int n = word.length();
        int ans = 0;
        int i = 0;
        while (i < n) {
            if (word.charAt(i) != 'a') {
                i++;
                continue;
            }
            int j = i;
            int vowels = 1; // currently have 'a'
            while (j + 1 < n && word.charAt(j) <= word.charAt(j + 1)) {
                if (word.charAt(j) < word.charAt(j + 1)) {
                    vowels++;
                }
                j++;
            }
            if (vowels == 5) {
                ans = Math.max(ans, j - i + 1);
            }
            i = j + 1;
        }

        return ans;
    }
}
