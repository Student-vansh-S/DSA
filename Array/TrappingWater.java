public class TrappingWater {
    static int trappingWater(int arr[]){
        int n=arr.length;
        int TrapWater = 0,Waterlevel=0;
        int leftMax[]=new int[n];
        int rightMax[]=new int[n];
        leftMax[0]=arr[0];
        rightMax[n-1]=arr[n-1];

        //LeftMax
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(arr[i],leftMax[i-1]);
        }

        //RightMax
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(arr[i], rightMax[i+1]);
        }

        for(int i=0;i<n;i++){
            Waterlevel=Math.min(leftMax[i], rightMax[i]);
            TrapWater+=Waterlevel-arr[i];
        }

        return TrapWater;
    }
    public static void main(String[] args) {
        int arr[]={4,2,0,6,3,2,5};
        int result;
        result=trappingWater(arr);
        System.out.println("Trapping Water :"+result);
    }
}
