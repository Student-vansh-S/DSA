public class QuickSort {
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.err.print(arr[i]+" ");
        }
    }

    public static void quickSort(int[] arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int pivotIdx=partition(arr,si,ei);
        quickSort(arr, si, pivotIdx-1);    //Left
        quickSort(arr, pivotIdx+1, ei);    //Right
    }

    public static int partition(int[] arr,int si,int ei){
        int pivot=arr[ei];
        int i=si-1; //to make place elements smaller than pivot
        for(int j=si;j<ei;j++){
            if(arr[j]<pivot){
                i++;
                //swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static void main(String[] args) {
        int[] arr={23,15,42,11,16,7,9,2};
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }
    
}
