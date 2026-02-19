import java.util.*;
public class CombinationSum_I {
    public static void getAllCombination(int[] candidates, int idx, int target,List<List<Integer>> result, List<Integer> comb) {
        if (target == 0) {
            result.add(new ArrayList<>(comb)); // adding copy of combination
            return;
        }
        if (idx == candidates.length || target < 0) // index out of the bound or tagret negative 
            return;
        // Include (can reuse same element)
        comb.add(candidates[idx]);
        getAllCombination(candidates, idx, target - candidates[idx], result, comb);
        comb.remove(comb.size() - 1); // backtrack
        // Exclude 
        getAllCombination(candidates, idx + 1, target, result, comb);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getAllCombination(candidates, 0, target, result, new ArrayList<>());
        return result;
    }
    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        System.out.println(combinationSum(candidates, 7));
    }
}
