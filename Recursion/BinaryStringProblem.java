public class BinaryStringProblem {
    // Generate all binary strings of length n without adjacent 1s
    public static void printOneBS(int n,int lastplace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        printOneBS(n-1,0, str+"0");
        if(lastplace==0){
            printOneBS(n-1, 1, str+"1");
        }
    }
    // Generate all binary strings of length n without adjacent 0s
    public static void printZeroBS(int n,int lastplace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        printZeroBS(n-1,1, str+"1");
        if(lastplace!=0){
            printZeroBS(n-1, 0, str+"0");
        }
    }
    public static void main(String[] args) {
        printOneBS(3, 0, new String());
        // printZeroBS(3, 1, new String());
    }
    
}
