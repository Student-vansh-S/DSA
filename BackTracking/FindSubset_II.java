import java.util.*;
public class FindSubset_II {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public static void backtrack(int[] nums, int index,List<Integer> temp,List<List<Integer>> result) {
        result.add(new ArrayList<>(temp)); // Add current subset
        for (int i = index; i < nums.length; i++) {
            // Skip duplicates at same recursion level
            if(i>index && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, result);            
            temp.remove(temp.size() - 1); // Backtrack
        }
    }
    public static void main(String[] args) {
        int nums[]={1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}