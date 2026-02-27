public class RecursionQuestions {
    //Decreasing order
    public static void decOrder(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        decOrder(n-1);
    }

    //Increasing Order
    public static void incOrder(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        incOrder(n-1);
        System.out.println(n);
    }

    //Factorial Number
    public static int factN(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*factN(n-1);
    }

    //Sum of n Natural number
    public static int sumN(int n){
        if(n==1){
            return 1;
        }
        return n+sumN(n-1);
    }

    //Fibonacci series
    public static int fibo(int n){
        if (n==1 || n==0) {
                return n;            
        }
        return fibo(n-1)+fibo(n-2);
    }

    //Check array is sorted or not
    public static boolean sortedArray(int[] arr,int i){
        if(i>arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return sortedArray(arr, i+1);
    }

    //First occurence in an array
    public static int firstOIA(int[] arr,int i,int key){
        if(i==arr.length-1){
            return -1;
        }
        if(key==arr[i]){
            return i;
        }
        return firstOIA(arr, i+1, key);
    }

    //Last occurence in an array
    public static int lastOIA(int[] arr,int i,int key){
        if(i==arr.length-1){
            return -1;
        }
        int isFound=lastOIA(arr, i+1, key);
        if(isFound==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }

    //Power function
    public static int power(int n,int x){
        // Approach 1 Time-Complexity O(n)
        // if(x==0){
        //     return 1;
        // }
        // return n*power(n, x-1);

        // Approach 2 Time-Complexity O(log n)
        if(x==0){
            return 1;
        }
        int halfpower=power(n, x/2);
        int halfpowerSq=halfpower*halfpower;
        if((x%2 )!= 0){
            halfpowerSq=n*halfpowerSq;
        }
        return halfpowerSq;
    }
    public static void main(String[] args) {
        decOrder(10);
        // incOrder(15);
        // System.out.println(factN(5));
        // System.out.println(sumN(5));
        // System.out.println(fibo(7));
        // int[] arr={13,22,34,4,5,4,13,45}; 
        // System.out.println(sortedArray(arr, 0));
        // System.out.println(firstOIA(arr, 0, 45));
        // System.out.println(lastOIA(arr, 0, 13));
        // System.out.println(power(2, 5));++++++++
    }
    
}
