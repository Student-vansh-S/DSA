public class AssignmentQuestions {
    public static void PrintMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void TransposeMatrix(int[][] matrix,int row,int col){
        int[][] Mat=new int[col][row]; 
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                Mat[j][i]=matrix[i][j];
            }
        }
        System.out.println("Transpose Matrix");
        PrintMatrix(Mat);
    }
    public static void main(String[] args) {
        // int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
        // int sum=0,flag=0;
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=0;j<nums.length;j++){
        //         if(i==1){
        //         sum=sum+nums[i][j];
        //         flag++;
        //         }
        //     }
        //     if(flag==1){
        //         break;
        //     }
        // }
        // System.out.println("Sum of 2nd Row :"+sum);
        int row=2,col=3;
        int[][] matrix={{1,2,3},
                        {4,5,6}};
        System.out.println("The Original Matrix");
        PrintMatrix(matrix);
        TransposeMatrix(matrix, row, col);

    }
    
}
