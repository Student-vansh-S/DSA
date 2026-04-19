import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int max = Integer.MIN_VALUE;

        // Step 1: initialize
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[]{val, i, 0}); // value, listIndex, elementIndex
            max = Math.max(max, val);
        }

        int start = 0, end = Integer.MAX_VALUE;

        // Step 2: process
        while (true) {
            int[] curr = pq.poll();
            int min = curr[0];
            int listIdx = curr[1];
            int eleIdx = curr[2];

            // update range
            if (max - min < end - start) {
                start = min;
                end = max;
            }

            // move pointer in that list
            if (eleIdx + 1 == nums.get(listIdx).size()) {
                break; // one list finished
            }

            int nextVal = nums.get(listIdx).get(eleIdx + 1);
            pq.offer(new int[]{nextVal, listIdx, eleIdx + 1});

            max = Math.max(max, nextVal);
        }

        return new int[]{start, end};
    }
}
