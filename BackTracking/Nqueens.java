public class Nqueens {
    /*
    leetcode solution for List<List<String>>
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        nqueens(board, 0, ans);
        return ans;
    }
    private void nqueens(char[][] board, int row, List<List<String>> ans) {
        // base case
        if (row == board.length) {
            ans.add(build(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nqueens(board, row + 1, ans);
                board[row][col] = '.'; // backtrack
            }
        }
    }
    private boolean isSafe(char[][] board, int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }
        // left diagonal up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // right diagonal up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    private List<String> build(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
    */
    public static boolean isSafe(char[][] board,int row,int col){
        // vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]== 'Q'){
                return false;
            }
        }

        //left diagonal up
        for(int i=row-1,j=col-1; i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //right diagonal up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if (board[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }

    public static void nqueens(char[][] board,int row){
        //base
        if(row == board.length){
            printBoard(board);
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]= 'Q';
                nqueens(board, row+1); // function call
                board[row][j] = '.'; // BackTraking step
            }
        }
    }

    public static void printBoard(char[][] board){
        System.out.println("-----------Chess Board-----------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=4;
        char board[][] = new char[n][n];
        if (n == 2 || n == 3) {
            System.out.println("No such positions of N queens is found in "+n+" * "+n);
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        nqueens(board,0);
    }
    
}
