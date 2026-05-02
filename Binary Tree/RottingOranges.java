import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        // Step 1: initialize queue + count fresh
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j}); // rotten
                } 
                else if (grid[i][j] == 1) {
                    fresh++; // fresh
                }
            }
        }

        // directions (4-dir)
        int[][] dir = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        int time = 0;

        // Step 2: BFS
        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                for (int[] d : dir) {
                    int ni = curr[0] + d[0];
                    int nj = curr[1] + d[1];

                    if (ni >= 0 && nj >= 0 && ni < m && nj < n 
                        && grid[ni][nj] == 1) {

                        grid[ni][nj] = 2; // make rotten
                        q.offer(new int[]{ni, nj});
                        fresh--;
                    }
                }
            }

            time++; // one minute passed
        }

        return fresh == 0 ? time : -1;
    }
}
