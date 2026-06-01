// import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeRequiredToFillGivenNSlots {
    //Approach 1 : Multi-Source BFS (Best Conceptual)
    public static int minTime(int n, int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        // Step 1: push all filled slots
        for (int x : arr) {
            q.offer(x);
            visited[x] = true;
        }

        int time = 0;

        // Step 2: BFS
        while (!q.isEmpty()) {
            int size = q.size();
            boolean expanded = false;

            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                // left
                if (curr - 1 >= 1 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    q.offer(curr - 1);
                    expanded = true;
                }

                // right
                if (curr + 1 <= n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    q.offer(curr + 1);
                    expanded = true;
                }
            }
            if (expanded) time++; // only increase if spread happens
        }
        return time;
    }

    //Approach 2 : Greedy (Most Optimal Thinking)
    // public static int minTime(int n, int[] arr) {
    //     Arrays.sort(arr);

    //     int maxTime = 0;

    //     // Left edge
    //     maxTime = Math.max(maxTime, arr[0] - 1);

    //     // Right edge
    //     maxTime = Math.max(maxTime, n - arr[arr.length - 1]);

    //     // Middle gaps
    //     for (int i = 1; i < arr.length; i++) {
    //         int gap = (arr[i] - arr[i - 1]) / 2;
    //         maxTime = Math.max(maxTime, gap);
    //     }

    //     return maxTime;
    // }
}
