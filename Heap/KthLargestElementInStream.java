import java.util.PriorityQueue;

public class KthLargestElementInStream {
    static class KthLargest {
        int size;
        PriorityQueue<Integer> pq;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            size = k;
            for (int num : nums) {
                pq.offer(num);
                if (pq.size() > k)
                    pq.poll();
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > size)
                pq.poll();
            return pq.peek();
        }
    }
}
