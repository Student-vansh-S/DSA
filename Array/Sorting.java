import java.util.*;

public class Sorting {

    public static void bubbleSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            boolean swaped=false;
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    swaped=true;
                }
            }
            if(!swaped){
                break;
            }
        }
    }

    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }

    public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    public static void printarr(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void countingSort(int[] arr){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest, arr[i]);
        }

        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int nums[]={1,4,1,3,2,4,3,7};
        // bubbleSort(nums);
        // selectionSort(nums);
        // insertionSort(nums);
        // Arrays.sort(nums);
        // Arrays.sort(nums,0,4);
        countingSort(nums);
        printarr(nums);
    }
}
