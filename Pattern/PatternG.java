public class PatternG {
    static void Butterfly(int n){
        // first half
        for(int i=1; i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int k=1;k<=2*(n-i);k++){
                System.out.print(" ");
            }
            for(int p=1;p<=i;p++){
                System.out.print("*");
            }
            System.out.println();
        }
        //second half
        for(int i=n; i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int k=1;k<=2*(n-i);k++){
                System.out.print(" ");
            }
            for(int p=1;p<=i;p++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void solid_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int k=1;k<=n;k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    
    static void Hollow_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int k=1;k<=n;k++){
                if(i==1||i==n||k==1||k==n){
                System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    static void daimond(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int k=1;k<=2*(i-1);k++){
                System.out.print("*");
            }
            System.out.println("");
        }
        
        for(int i=n;i>=1;i--){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int k=1;k<=(2*i)-1;k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        // Butterfly(5);
        // solid_rhombus(5);
        // Hollow_rhombus(5);
        daimond(4);
    }
}
