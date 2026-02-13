public class CountNqueens {
    static int count=0;
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
            count++;
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
        int n=6;
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
        System.out.println("Total ways to solve N-Queens : "+ count);
    }
}
