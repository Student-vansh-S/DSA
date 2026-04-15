import java.util.PriorityQueue;

public class KthLargestElementInStream {
    static class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>();

            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.offer(val);

            // keep only k elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // top = kth largest
            return minHeap.peek();
        }
    }
}
