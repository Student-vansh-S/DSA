public class PeakIndexInAMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        // Approach 1 TC- O(log n)
        // int n = arr.length;
        // int left = 1;         
        // int right = n - 2;    
        // while (left <= right) {
        //     int mid = left + (right - left) / 2;
        //     if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
        //         return mid; 
        //     if (arr[mid] < arr[mid + 1]) {
        //         left = mid + 1;
        //     } else{
        //         right = mid - 1;
        //     }
        // }
        // return -1;

        // Approach 2 TC- O(log n)
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;    
            } else {
                right = mid;       
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr={0,10,5,2};
        System.out.println("Peak Mountain Index : "+peakIndexInMountainArray(arr));
    }   
}
