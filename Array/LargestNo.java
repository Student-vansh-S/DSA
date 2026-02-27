public class LargestNo {
    static int large_number(int arr[]){
        // int large;
        int large=Integer.MIN_VALUE;
        int small=Integer.MAX_VALUE;
        // large=arr[0];
        for(int i=0;i<arr.length;i++){
            if(large<arr[i]){
                large=arr[i];
            }
            if(small>arr[i]){
                small=arr[i];
            }
        }
        System.out.println("Small :"+small);
        return large;
    }
    public static void main(String[] args) {
        int arr[]={1,5,8,2,51,21,45};
        int large;
        large=large_number(arr);
        System.out.println("Largest Number in array :"+large);
    }
}
