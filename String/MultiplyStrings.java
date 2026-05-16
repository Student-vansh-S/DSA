public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // edge case
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];
        // multiply from right to left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = product + result[p2];
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }
        // build final string
        StringBuilder ans = new StringBuilder();
        for (int num : result) {
            // skip leading zeros
            if (!(ans.length() == 0 && num == 0)) {
                ans.append(num);
            }
        }
        return ans.toString();
    }
}
