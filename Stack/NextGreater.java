import java.util.*;
public class NextGreater {
    /* Leetcode code
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // Find next greater element for every value in nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], s.peek());
            }
            s.push(nums2[i]);
        }
        // Build answer for nums1
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
     */
    public static void nextGreater(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] nextGreater = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        nextGreater(arr);
    }
}