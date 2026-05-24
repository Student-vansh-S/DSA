import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int n = nums.length;
        // Approach 1 O(n logn)
        // Arrays.sort(nums);
        // int max=Integer.MIN_VALUE;
        // int i=0;
        // for(int j=1;j<n;j++){
        //     max = Math.max(max,nums[j]-nums[i]);
        //     i++;
        // }
        // return max;

        // Approach 2 O(n) 
        // find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // all same numbers
        if (min == max) {
            return 0;
        }

        // bucket size
        int bucketSize = Math.max(1, (max - min) / (n - 1));

        // number of buckets
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] used = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // place numbers into buckets
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
            used[idx] = true;
        }

        // find maximum gap
        int prev = min;
        int ans = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (!used[i]) {
                continue;
            }
            ans = Math.max(ans, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        return ans;
    }
}
