import java.util.Arrays;
public class plusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        // Traverse from last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;     // add 1
                return digits;   // no carry needed
            }
            digits[i] = 0;       // if digit was 9, make it 0
        }
        // If all digits were 9
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
