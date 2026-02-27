import java.util.Scanner;

public class EvenOdd{
    public static void main(String agr[]){
        Scanner S = new Scanner(System.in);
        int year;   
        System.out.println("Enter year:");
        year=S.nextInt();
        boolean x= (year%4) ==0;
        boolean y= (year%100) !=0;
        boolean z= ((year%100==0) && (year%400==0));
        if(x && (y || z)){
            System.out.println("This year is a leap Year");
        } else{
            System.out.println("This year is not a leap Year");
        }
    }
}