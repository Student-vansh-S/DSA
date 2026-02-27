import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        int n,temp,sum=0;
        Scanner S=new Scanner(System.in);
        System.out.println("Enter your number :");
        n=S.nextInt();
        temp=n;
        while(temp>0){
            int m=temp%10;
            sum=(10*sum)+m;
            temp=temp/10;
        }
        if(n==sum){
            System.out.println("The number is palindrome number");
        }
        else{
            System.out.println("The number is not palindrome number");
        }
    }
}
