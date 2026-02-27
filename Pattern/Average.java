import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int a,b,c=0;
        float average=0;
        Scanner S=new Scanner(System.in);
        System.out.println("Enter any three numbers :");
        a=S.nextInt();
        b=S.nextInt();
        c=S.nextInt();
        average=(float) ((float) a+b+c/3.0);
        System.out.println("Average :"+average);
    }
}
