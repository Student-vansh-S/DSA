import java.util.Arrays;

public class CheckIfArrayIsGood {
    // Approach 1
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        // check 1 to n-1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        // last element must also be n
        return nums[n] == n;
    }
    
    /* 
    Approach 2
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        for (int a : nums) {
            if (a >= n) {
                return false;
            }
            if (a < n - 1 && count[a] > 0) {
                return false;
            }
            if (a == n - 1 && count[a] > 1) {
                return false;
            }
            count[a]++;
        }
        return true;
    }
        */
}
