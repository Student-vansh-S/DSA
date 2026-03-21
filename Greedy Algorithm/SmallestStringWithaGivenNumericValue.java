public class SmallestStringWithaGivenNumericValue {
    public static String getSmallestString(int N, int K) {
        char[] ans = new char[N];

        // Fill all positions with 'a'
        for (int i = 0; i < N; i++) {
            ans[i] = 'a';
        }

        // Remaining value after using N times 'a'
        int extra = K - N;

        // Fill from right to left
        for (int i = N - 1; i >= 0; i--) {
            int add = Math.min(25, extra);
            ans[i] = (char)(ans[i] + add);
            extra -= add;

            if (extra == 0) break;
        }

        return new String(ans);
    }
    public static void main(String[] args) {
        int n = 5;
        int k = 47;
        String result = getSmallestString(n,k);
        System.out.println(result);
    }
}