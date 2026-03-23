public class KthLargestOddNumberInRange {

    public static int kthOdd(int[] range, int K) {
        if (K <= 0)
            return 0;

        int L = range[0];
        int R = range[1];

        // count odd numbers
        int count = ((R + 1) / 2) - (L / 2);

        if (K > count) {
            return 0;
        }

        int largestOdd = (R % 2 == 1) ? R : R - 1;

        return largestOdd - (K - 1) * 2;
    }

    public static void main(String[] args) {
        int[] range = {1, 11}; 
        int k = 2;

        int result = kthOdd(range, k);
        System.out.println("The " + k + "-th largest odd number is: " + result);
    }
}