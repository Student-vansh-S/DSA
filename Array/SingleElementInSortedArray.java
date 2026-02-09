public class SingleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        //Approach 1
        // int n = arr.length;
        // if(n==1) return arr[0];
        // int st=0, end=n-1;
        //     while(st<end){
        //         int mid =st+(end-st)/2;

        //         if(mid==0 && arr[0]!=arr[1]) return arr[0];
        //         if(mid==n-1 &&arr[n-1]!=arr[n-2]) return arr[n-1];
        //         if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) return arr[mid];

        //         if(mid%2==0){
        //             if(arr[mid]==arr[mid-1]) end=mid+1;
        //             else st=mid+1;
        //         }
        //         else{
        //             if(arr[mid]==arr[mid-1]) st=mid+1;
        //             else end=mid;
        //         }             
        //     }
        //     return arr[st];

        //Approach 2
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // make mid even
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;   
            } else {
                right = mid;      
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}
