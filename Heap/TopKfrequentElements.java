import java.util.*;

public class TopKfrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b)); // Priority Queue (Min Heap), comparing frequencies (a-b => Ascending order)

        for (int num : freqMap.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        int i=0;
        while (!heap.isEmpty()) {
            res[i] = heap.poll();
            i++;
        }
        return res;
    }    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,3};
        int k=2;
        int[] result = topKFrequent(arr, k);
        System.out.println(Arrays.toString(result));
    }
}
