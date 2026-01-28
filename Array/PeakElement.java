public class PeakElement {
    public static int checkPeakElement(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=left+(right-left)/2; // Mid
            if(arr[mid]<arr[mid+1]){
                left=mid+1; // goto right
            }
            else{
                right=mid; // goto left
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,8,6};
        System.out.println("Peak element index :"+checkPeakElement(arr));
    }
    
}
