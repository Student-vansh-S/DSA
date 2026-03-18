import java.util.*;

public class MaxLengthChainOfPairs {
    public static void chainPair(int[][] nums){
        int n = nums.length;
        Arrays.sort(nums , Comparator.comparingDouble(o -> o[1]));
        int chainLen = 1;
        int prevEnd = nums[0][1];
        for(int i=1;i<n;i++){
            if (nums[i][0] > prevEnd) {
                chainLen++;
                prevEnd = nums[i][1];
            }
        }
        System.out.println("Maximum length chain of pairs :"+chainLen);
    }

    // Leetcode Code 646
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);

        int count = 1;
        int end = pairs[0][1];

        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0] > end){
                count++;
                end = pairs[i][1];
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[][] nums = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        chainPair(nums);
    }
    
}
