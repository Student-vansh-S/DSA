public class SudokuSolver {
    /* Leetcode Answer
    class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }

    private boolean isSafe(char[][] board, int row, int col, char digit) {
        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) return false;
        }

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) return false;
        }

        // Check 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) return false;
            }
        }

        return true;
    }

    private boolean sudokuSolver(char[][] board, int row, int col) {
        // base case: solved all rows
        if (row == 9) return true;

        // next cell
        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // if already filled, move forward
        if (board[row][col] != '.') {
            return sudokuSolver(board, nextRow, nextCol);
        }

        // try digits
        for (char digit = '1'; digit <= '9'; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;

                if (sudokuSolver(board, nextRow, nextCol)) return true;

                board[row][col] = '.'; // backtrack
            }
        }

        return false;
    }
}
*/
    public static boolean isSafe(int sudoku[][], int row,int col,int digit){
        // Rule 1- check column
        for(int i=0;i<=8;i++){
            if (sudoku[i][col]==digit) {
                return false;
            }
        }

        //Rule 1-Check Row
        for(int j=0;j<=8;j++){
            if (sudoku[row][j]==digit) {
                return false;
            }
        }

        //Rule 1-Check grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        // 3x3 grid
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row,int col){
        // base case
        if(row == 9){
            return true;
        }

        // recursion
        int nextRow= row, nexCol = col+1;
        if (col+1 == 9) {
            nextRow = row+1;
            nexCol = 0;
        }

        if(sudoku[row][col] !=0){
            return sudokuSolver(sudoku, nextRow, nexCol);
        }

        for(int digit=1; digit<=9; digit++){
            if (isSafe(sudoku,row,col,digit)) {
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku,nextRow,nexCol)){
                    return true;
                }
                sudoku[row][col]=0; // backtrack
            }
        }
        return false;
    }

    public static void printSudoku(int[][] sudoku){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudoku[][] = {{5,3,0,0,7,0,0,0,0},
                           {6,0,0,1,9,5,0,0,0},
                           {0,9,8,0,0,0,0,6,0},
                           {8,0,0,0,6,0,0,0,3},
                           {4,0,0,8,0,3,0,0,1},
                           {7,0,0,0,2,0,0,0,6},
                           {0,6,0,0,0,0,2,8,0},
                           {0,0,0,4,1,9,0,0,5},
                           {0,0,0,0,8,0,0,7,9}};
        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("Soluton is exist");
            System.out.println("----------Sudoku------------");
            printSudoku(sudoku);
        }else{
            System.out.println("Solution Does not exist");
        }
    }
}
