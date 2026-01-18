public class MergeSort {
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.err.print(arr[i]+" ");
        }
    }

    public static void mergeSort(int[] arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2; //Mid index
        //Left part
        mergeSort(arr, si, mid);
        //Right part
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr,int si,int mid,int ei){
        int[] temp= new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        //If left part remain
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        //If right part remain
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        //Copy temp value to original value
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    public static void main(String[] args) {
        int[] arr={23,15,42,11,16,7,9,2};
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
    
}
