import java.util.*;
public class CombinationSumII {
    public static void getAllCombination(int[] candidates, int idx, int target,List<List<Integer>> result, List<Integer> comb) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            comb.add(candidates[i]);
            getAllCombination(candidates, i + 1, target - candidates[i], result, comb);
            comb.remove(comb.size() - 1); // backtrack
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); 
        getAllCombination(candidates, 0, target, result, new ArrayList<>());
        return result;
    }
    public static void main(String[] args) {
     int[] candidates={10,1,2,7,6,1,5};
     int target=8;
     System.out.println(combinationSum2(candidates, target));   
    }
}
