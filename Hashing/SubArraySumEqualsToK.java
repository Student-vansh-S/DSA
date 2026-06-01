import java.util.HashMap;

public class SubArraySumEqualsToK {
    public static void main(String[] args) {
        int nums[] = {10,2,-2,-20,10};
        HashMap<Integer,Integer> map = new HashMap<>(); //(Sum , count)
        int k= -10;
        int sum =0;
        int ans =0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            if (map.containsKey(sum-k)) { //O(n)
                ans+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
}
