import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinABSdifferencePairs {
    public static void minABS(int[] a,int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int minDiff = 0;
        for(int i=0;i<a.length;i++){
            minDiff += Math.abs(a[i]-b[i]);
        }
        System.out.println("Minimum Absolute Difference Pairs :"+minDiff);
    }

    // LeetCode 1200. Minimum Absolute Difference
    public List<List<Integer>> minimumAbsDifference(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        // Step 1: find minimum difference
        for (int i = 1; i < a.length; i++) {
            minDiff = Math.min(minDiff, a[i] - a[i - 1]);
        }
        // Step 2: collect pairs with minimum difference
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] == minDiff) {
                List<Integer> pair = new ArrayList<>();
                pair.add(a[i - 1]);
                pair.add(a[i]);
                result.add(pair);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {4,1,8,7};
        int[] b = {2,3,6,5};
        minABS(a, b);
    }
}
