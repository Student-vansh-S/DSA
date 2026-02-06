public class WordSearch {
    static boolean[][] visited;
    public static boolean wordExist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if((word.charAt(0)==board[i][j]) && search(board,word,i,j,0)){
                    return true;
                } 
            }
        }
        return false;
    }

    public static boolean search(char[][] board,String word,int i,int j,int idx){
        if(idx == word.length()){
            return true;
        }
        if(i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j] != word.charAt(idx) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(search(board,word,i-1,j,idx+1) || search(board,word,i+1,j,idx+1) || search(board,word,i,j+1,idx+1) || search(board,word,i,j-1,idx+1)){
            return true;
        }
        visited[i][j]= false;
        return false;
    }
    public static void main(String args[]){
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(wordExist(board,word));
    }
}
