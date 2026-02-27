public class TilingProblem {
    public static int tiling(int n){
        //Base Case
        if(n==1 || n==0){
            return 1;
        }
        //Vertically Placed 
        // int vertically=tiling(n-1);

        // //Horizontally Placed 
        // int horizontally=tiling(n-2);

        return tiling(n-1)+tiling(n-2);
    }
    public static void main(String[] args) {
        System.out.println("Ways :"+tiling(5));
    }
}
