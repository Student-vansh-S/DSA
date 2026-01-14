public class MaxProductSubArr {
    public static int maxSubProduct(int[] nums){
                    
               // **1st Apporach**
        // int maxp=Integer.MIN_VALUE;
        // for(int i=0;i<=nums.length-1;i++){
        //     int product=1;
        //     product=product*nums[i];
        //     for(int j=i+1;j<=nums.length-1;j++){
        //         product=product*nums[j];
        //     }
        //     maxp=Math.max(maxp, product);
        //     }
        //     return maxp;

                    // **2nd Approach**
            int maxi=nums[0];
            int mini=nums[0];
            int ans=nums[0];

            for(int i=1;i<nums.length;i++){
                if(nums[i]<0){
                    int temp;
                    temp=maxi;
                    maxi=mini;
                    mini=temp;
                }
                maxi=Math.max(maxi*nums[i], nums[i]);
                mini=Math.min(mini*nums[i], nums[i]);
                ans=Math.max(maxi, ans);
            }
            return ans;
        }
        
    public static void main(String[] args) {
        int arr[]={2,3,-2,4};
        System.out.println("Maximum Product of Sub array :"+maxSubProduct(arr));
    }
}
