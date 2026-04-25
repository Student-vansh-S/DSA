public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        int expected = n * (n + 1) / 2;
        return expected - sum;
    }
}