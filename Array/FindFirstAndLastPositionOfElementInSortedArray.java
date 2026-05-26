public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = firstPosition(nums, target);
        ans[1] = lastPosition(nums, target);
        return ans;
    }

    // first occurrence
    public int firstPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                // move left
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return ans;
    }

    // last occurrence
    public int lastPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                // move right
                start = mid + 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }

    // Appraoch 2
    public int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {

                int left = mid;
                int right = mid;

                // move left
                while (
                    left - 1 >= 0 &&
                    nums[left - 1] == target
                ) {
                    left--;
                }

                // move right
                while (
                    right + 1 < nums.length &&
                    nums[right + 1] == target
                ) {
                    right++;
                }

                ans[0] = left;
                ans[1] = right;

                return ans;
            }

            else if (nums[mid] < target) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
