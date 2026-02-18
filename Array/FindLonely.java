import java.*;
public class FindLonely {
    public static List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        // map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }
        // for(int i=0;i<nums.length;i++){
        // if(map.get(nums[i])==1 && !map.containsKey(nums[i]-1) &&
        // !map.containsKey(nums[i]+1)){
        // result.add(nums[i]);
        // }
        // }
        // return result;

        //Without extra space TC-O(nlogn)and SC-O(1)
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        Arrays.sort(nums);
        // Handling first element
        if(nums[1]-nums[0]>1){
            result.add(nums[0]);
        }
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i]-nums[i-1]>1 && nums[i+1]-nums[i]>1){
                result.add(nums[i]);
            }
        }
        //Handling last element
        if(nums[nums.length-1]-nums[nums.length-2]>1){
            result.add(nums[nums.length-1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 3 };
        System.out.println(findLonely(nums));
    }
}
