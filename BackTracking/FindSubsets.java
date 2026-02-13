import java.util.ArrayList;
import java.util.List;

public class FindSubsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public static void backtrack(int[] nums, int index,List<Integer> temp,List<List<Integer>> result) {
        result.add(new ArrayList<>(temp)); // Add current subset
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, result);            
            temp.remove(temp.size() - 1); // Backtrack
        }
    }
 public static void main(String[] args) {
    int[] nums={1,2,3};
    System.out.println(subsets(nums)); // TC O(2^n) and SC O(n)
 }   
}
