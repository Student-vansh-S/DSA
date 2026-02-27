public class RotatedSort{
    public static void Search(int[] nums,int target){
        int r=nums.length-1;
        int result;
        int min = minSearch(nums);
        if(nums[min]<=target&&target<=nums[r]){
            result=SearchBS(nums, min, r, target);
        }
        else{
            result=SearchBS(nums, 0, min, target);
        }
        System.out.println(result);

    }

    public static int minSearch(int[] nums){
        int l=0;
        int r=nums.length-1;
        while (l<r) {
            int mid=l+(r-l)/2;
            if(mid>0 && nums[mid-1]>nums[mid]){
                return mid;
            }
            else if(nums[l]<=nums[mid]&&nums[mid]>nums[r]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }
    public static int SearchBS(int[] nums,int left,int right,int target){
        int l=left;
        int r=right;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
            return mid;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[]={4,5,6,7,1,2,3};
        Search(nums, 7);
    }
}