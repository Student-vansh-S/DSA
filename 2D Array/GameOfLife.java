public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // APproach 1
        // int[] dir = {-1, 0, 1};
        // // Step 1: Apply rules using markers
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         int liveNeighbors = 0;
        //         // check 8 neighbors
        //         for (int x : dir) {
        //             for (int y : dir) {
        //                 if (x == 0 && y == 0) continue;
        //                 int ni = i + x;
        //                 int nj = j + y;
        //                 if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
        //                     if (board[ni][nj] == 1 || board[ni][nj] == -1) {
        //                         liveNeighbors++;
        //                     }
        //                 }
        //             }
        //         }
        //         // apply rules
        //         if (board[i][j] == 1) {
        //             if (liveNeighbors < 2 || liveNeighbors > 3) {
        //                 board[i][j] = -1; // live → dead
        //             }
        //         } else {
        //             if (liveNeighbors == 3) {
        //                 board[i][j] = 2; // dead → live
        //             }
        //         }
        //     }
        // }
        // // Step 2: Final update
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (board[i][j] > 0) {
        //             board[i][j] = 1;
        //         } else {
        //             board[i][j] = 0;
        //         }
        //     }
        // }

        // Approach 2
        // Step 1: Create a copy of the board
        int[][] temp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = board[i][j];
            }
        }

        // 8 directions (neighbors)
        int[][] dir = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},        {0,1},
            {1,-1},{1,0},{1,1}
        };

        // Step 2: Traverse each cell
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                int live = 0;

                // Count live neighbors from temp
                for(int[] d : dir){
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if(ni >= 0 && nj >= 0 && ni < m && nj < n 
                        && temp[ni][nj] == 1){
                        live++;
                    }
                }

                // Apply rules
                if(temp[i][j] == 1){
                    // Live cell
                    if(live < 2 || live > 3){
                        board[i][j] = 0; // dies
                    }
                } else {
                    // Dead cell
                    if(live == 3){
                        board[i][j] = 1; // becomes alive
                    }
                }
            }
        }
    }
}
