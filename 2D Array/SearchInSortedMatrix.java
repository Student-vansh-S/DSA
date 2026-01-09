public class SearchInSortedMatrix {
    public static boolean SearchInMatrix(int[][] mat,int key){
    /*  Approach 1
        int row=0;
        int col=mat.length-1;
        while(row<mat.length&& col>=0){
            if(mat[row][col]==key){
                System.out.println("Element found at position ("+row+","+col+").");
                return true;
            }
            else if(key>mat[row][col]){
                row++;
            }
            else{
                col--;
            }
        }
    */ 
    // Approach 2
        int row=mat.length-1;
        int col=0;
        while(row>=0 && col<mat.length){
            if(mat[row][col]==key){
                System.out.println("Element found at position ("+row+","+col+").");
                return true;
            }
            else if(key>mat[row][col]){
                col++;
            }
            else{
                row--;
            }
        }
        System.out.println("Key not found!");
        return false;
    }
    public static void main(String[] args) {
        int[][] mat={
                     {10,20,30,40},
                     {15,25,35,45},
                     {27,29,37,48},
                     {32,33,39,50}
                    };
        int key=45;
        SearchInMatrix(mat, key);
    }
}
