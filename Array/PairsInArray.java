public class PairsInArray {
    static void pairs(int arr[]){
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+arr[i]+","+arr[j]+")");
            }
            System.out.println("");
        }
        int n,totalPair=0;
        n=arr.length;
        totalPair=n*(n-1)/2;
        System.out.println("Total pairs :"+totalPair);
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        pairs(arr);
    }
}
