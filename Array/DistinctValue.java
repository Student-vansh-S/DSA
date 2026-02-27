public class DistinctValue {
    static boolean checkVal(int nums[]){
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,1};
        boolean result=checkVal(nums);
        System.out.println(result); 
    }
}