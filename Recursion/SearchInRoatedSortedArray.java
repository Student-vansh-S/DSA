public class SearchInRoatedSortedArray {
    //With Recursion
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

    //With Loop
    public static void searchWithLoop(int[] arr,int si,int ei,int key){
        int flag=0;
        for(int i=0;i<arr.length;i++){
            int mid=si+(ei-si)/2;            
            //Found condition
            if(arr[mid]==key){
                System.err.println("Key found at index :"+mid);
                flag=1;
                break;
            }
            //mid on L1
            if(arr[si]<=arr[mid]){
                //case a:left
                if(arr[si]<=key&& key<=arr[mid]){
                ei=mid-1;
                }
                //case b:right
                else{
                    si=mid+1;
                }
            }
            //mid on L2
            else {
                if(arr[mid]<=key&& key<=arr[ei]){
                    si=mid+1;
                }
                else{
                    ei=mid-1;
                }
            }
        }
        if(flag==0){
            System.err.println(-1);
        }
    }
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2,3};
        int key=3;
        System.out.println("Key found at index :"+search(arr, key, 0, arr.length-1));
        // searchWithLoop(arr, 0, arr.length-1, key);
    }
    
}
