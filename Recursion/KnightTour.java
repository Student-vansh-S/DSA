import java.util.Scanner;

public class KnightTour {
    public static boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        // 1. If starting cell is not 0, return false
        if (grid[0][0] != 0)
            return false;
        // 2. Store positions of each number
        int[][] pos = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                pos[val][0] = i;
                pos[val][1] = j;
            }
        }
        // 3. Check knight moves between consecutive numbers
        for (int i = 0; i < n * n - 1; i++) {
            int r1 = pos[i][0];
            int c1 = pos[i][1];
            int r2 = pos[i + 1][0];
            int c2 = pos[i + 1][1];
            int dr = Math.abs(r1 - r2);
            int dc = Math.abs(c1 - c2);
            // Valid knight move check
            if (!((dr == 2 && dc == 1) || (dr == 1 && dc == 2))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        System.out.println("Enter the grid values:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        boolean result = checkValidGrid(grid);

        System.out.println("Is valid Knight Tour  : " + result);

        sc.close();
    }
}
