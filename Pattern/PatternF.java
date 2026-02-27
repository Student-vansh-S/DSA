public class PatternF {
    public static void main(String arg[]){
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(i==1||i==8||j==1||j==8){
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
