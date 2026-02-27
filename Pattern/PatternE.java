public class PatternE {
    public static void main(String arg[]){
        int c=1;
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(c);
                if(c==1){
                    c=0;
                }else{
                    c=1;
                }
            }
            System.out.println("");
        }
    }
}
