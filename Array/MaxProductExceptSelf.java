public class MaxProductExceptSelf {
    public static int[] maxProduct(int[] nums){
        int arr[]=new int[nums.length];
        int prefix=1;
        int suffix=1;
        for(int i=0;i<arr.length;i++){
        arr[i]=prefix;
        prefix*=nums[i];
        }
        for(int j=arr.length-1;j>=0;j--){
            arr[j]*=suffix;
            suffix*=nums[j];
        }
        return arr;
    }
    public static void printArr(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int[] ans=maxProduct(nums);
        printArr(ans);
    }
}
