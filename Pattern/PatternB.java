public class PatternB {
    public static void main(String arg[]){
        int row = 4;
        int col = 4;
        for(int i=1;i<=row;i++){
            for(int j=0;j<row-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
