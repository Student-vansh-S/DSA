import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        
        // Step 1: add elements
        for (int num : nums) {
            sum += num;
            maxHeap.offer((double) num);
        }
        double target = sum / 2;
        int operations = 0;

        // Step 2: reduce
        while (sum > target) {
            double largest = maxHeap.poll();
            double reduced = largest / 2;

            sum -= reduced;
            maxHeap.offer(reduced);

            operations++;
        }

        return operations;
    }
}
