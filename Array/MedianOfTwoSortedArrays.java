public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0, high = m;
        int left = (m + n + 1) / 2;
        int size = m + n;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int left1 = Integer.MIN_VALUE;
            int right1 = Integer.MAX_VALUE;
            int left2 = Integer.MIN_VALUE;
            int right2 = Integer.MAX_VALUE;
            if (mid1 < m)
                right1 = nums1[mid1];
            if (mid2 < n)
                right2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                left1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                left2 = nums2[mid2 - 1];
            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}