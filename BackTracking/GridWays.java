public class GridWays {
    public static int gridways(int i,int j,int n,int m){
        // Recursive approach TC- O(2^n+m) 
        // base case
        // if(i == n-1 || j==m-1){
        //     return 1;
        // }else if(i == n || j == m){
        //     return 0;
        // }
        // int way1= gridways(i+1, j, n, m);
        // int way2= gridways(i, j+1, n, m);
        // return way1+way2;

        // Permutation Formula
        int NmM= fact((n-1 + m-1));
        int repeatChar= fact(n-1) * fact(m-1);
        return NmM / repeatChar;
    }

    public static int fact(int n){
        if(n== 0 || n==1){
            return 1;
        }
        return  n * fact(n-1);
    }
 public static void main(String[] args) {
    int n=3,m=3;
    System.out.println(gridways(0, 0, n, m));
 }   
}
