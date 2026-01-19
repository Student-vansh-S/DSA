public class SearchInRoatedSortedArray {
    public static int search(int[] arr,int key,int si,int ei){
        if(si>ei){
            return -1;
        }
        int mid=si+(ei-si)/2;
        // Found Condition
        if(arr[mid]==key){
            return mid;
        }

        //mid in L1
        if(arr[si]<=arr[mid]){
            //Case a: Left
            if(arr[si]<=key&&key<=arr[mid]){
                return search(arr, key, si, mid-1);
            }
            //Case b: Right
            else{
                return search(arr, key, mid+1, ei);
            }
        }
        //mid on L2
        else{
            //Case c:Right
            if(arr[mid]<=key&&key<=arr[ei]){
                return search(arr, key, mid+1, ei);
            }
            //Case d:Left
            else{
                return search(arr, key, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        int key=4;
        System.out.println("Key found at index :"+search(arr, key, 0, arr.length-1));
    }
    
}
