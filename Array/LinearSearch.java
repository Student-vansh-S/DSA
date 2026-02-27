import java.util.*;

public class LinearSearch{
    static int LSearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(key==arr[i]){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner S=new Scanner(System.in);
        System.out.println("Enter the number no list :");
        int n=S.nextInt();
        int arr[]=new int[n];
        System.out.print("Enter your elements:");
        for(int i=0;i<n;i++){
            arr[i]=S.nextInt();
        }
        System.out.println("Enter your key");
        int key=S.nextInt();
        int res=LSearch(arr,key);
        System.out.println(res==-1?"Key no found":"Key found at "+(res+1) +"Position");
    }
}