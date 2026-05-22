public class UniqueSubStringsInWrapaorundString {
    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 &&(s.charAt(i) - s.charAt(i - 1) == 1 ||s.charAt(i - 1) - s.charAt(i) == 25)) {
                k++;
            } else {
                k = 1;
            }
            int idx = s.charAt(i) - 'a';
            dp[idx] = Math.max(dp[idx], k);
        }
        int sum = 0;
        for (int val : dp) {
            sum += val;
        }
        return sum;
    }
}
