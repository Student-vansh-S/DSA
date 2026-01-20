import java.util.Scanner;

public class Assingment {
    static String nums[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public static void printNumbers(int number){
        if(number==0){
            return;
        }
        int lastDigit=number%10;
        printNumbers(number/10);
        System.out.print(nums[lastDigit]+" ");
    }
    public static void printOcc(int[] n,int i,int key){
        if(i==n.length){
            return;
        }
        if(key==n[i]){
            System.out.println(i);
        }
        printOcc(n, i+1, key);
    }

    public static void strLn(String str,int i,int count){
        if(i==str.length()){
            System.out.println(count);
            return;
        }
        strLn(str, i++, count++);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // String str="Vansh Saini";
        // int[] arr={1,2,4,41,2,4,3,2,4};
        // printOcc(arr, 0, 4);
        // strLn(str, 0, 0);
        System.err.println("Enter Number [last number can't be zero] :");
        int n=sc.nextInt();
        printNumbers(n);
        sc.close();
    }
}
