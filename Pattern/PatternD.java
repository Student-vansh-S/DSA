public class PatternD {
    public static void main(String arg[]){
        // Scanner S=new Scanner(System.in);
        // int n;
        // System.out.println("Enter number :");
        // n=S.nextInt();
        int c=1;
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(c+" ");
                c++;
            }
            System.out.println("");
        }
    }    
}
