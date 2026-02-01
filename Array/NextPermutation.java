import java.util.*;
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        // Step 1: Find pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        // Step 2: If no pivot, reverse whole array
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        // Step 3: Find next greater element and swap
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }
        // Step 4: Reverse from pivot+1 to end
        reverse(nums, pivot + 1, n - 1);
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
