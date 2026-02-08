import java.util.*;
public class FindMissingAndReapeatedValue {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set=new HashSet<>();
        int a=0;
        int b;
        int expectedSum=0; 
        int actualSum=0;
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                actualSum+=grid[i][j];
                if(set.contains(grid[i][j])){
                    a=grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }
        expectedSum= (n*n*(n*n+1))/2;
        b= (expectedSum+a)-actualSum;
        return new int[]{a,b};
    }
    public static void main(String[] args) {
        int[][] grid = {{9,1,7},{8,9,2},{3,4,6}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }
    
}
