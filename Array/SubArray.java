public class SubArray {
    static void subArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k < j; k++) {
                    System.out.print("(" + arr[k] + ")");
                }
                System.out.println("");
            }
        }
    }

    // Basic Approach time complexity O(n^3)
    static void maxSubArraySum(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }
                System.out.println(currSum);
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum sum :" + maxSum);
    }

    //Second approach prefix approach O(n^2)
    static void prefixSum(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum sum :" + maxSum);
    }

    //Kadane's algo O(n)
    static void kadanesAlgo(int arr[]) {
        int currSum = 0;
        int min=0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currSum=currSum+arr[i];
            if(currSum<0){
                min++;
                currSum=0;
            }
            maxSum=Math.max(maxSum, currSum);
        }
        if(min==arr.length){
            System.out.println(-1);
        }else{
            System.out.println("Maximum sum :" + maxSum);
        }
    }

    public static void main(String[] args) {
        int arr[] = { -1, -2, 6, 1, 3 };
        // subArray(arr);
        // maxSubArraySum(arr);
        // prefixSum(arr);
        kadanesAlgo(arr);
    }
}
