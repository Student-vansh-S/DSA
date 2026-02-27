import java.util.*;
public class SubArraySum_k {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,1); // Initial PrefixSum,count for (Sum == k)
        int result=0;
        int prefixSum=0;
        for(int num:nums){
            prefixSum+=num;
            if(m.containsKey(prefixSum-k)){
                result+=m.get(prefixSum-k);
            }
            m.put(prefixSum,m.getOrDefault(prefixSum,0)+1);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr={9,4,0,20,3,10,5};
        int k=33;
        System.out.println("SubArray sum equals to "+k+" : "+subarraySum(arr, k));
    }
}
