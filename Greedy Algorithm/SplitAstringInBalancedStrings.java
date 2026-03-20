public class SplitAstringInBalancedStrings {
    public static int balancedStringSplit(String str) {
        int balance = 0;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'R') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        String str = "RLRRLLRLRL";
        int result = balancedStringSplit(str);
        System.out.println("Number of balanced strings: " + result);
    }
}
