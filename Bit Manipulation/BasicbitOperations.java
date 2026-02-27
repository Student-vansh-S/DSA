public class BasicbitOperations{
    public static boolean checkEvenOdd(int n){
        int bitMask=1;
        if ((n & bitMask)==0) {
            return true;
        }
        else{
            return false;
        }
    }

    public static int getIthBit(int n,int i){
        int bitMask=1<<i;
        if((n&bitMask)==0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static int setIthBit(int n,int i){
        int bitMask=1<<i;
        return n|bitMask;
    }

    public static int clearIthBit(int n,int i){
        int bitMask=~(1<<i);
        return n&bitMask;
    }

    public static int updateIthBit(int n,int i,int newbit){
        // if(newbit==0){
        //     return clearIthBit(n, i);
        // }
        // else{
        //     return setIthBit(n, i);
        // }

        n=clearIthBit(n, i);
        int BitMask=(newbit<<i);
        return n|BitMask;
    }

    public static int clearIBit(int n,int i){
        int bitMask=(~(0)<<i);
        return n&bitMask;
    }

    public static int clearRnageofBit(int n,int i,int j){
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;
        int bitMask=a|b;
        return n&bitMask;
    }

    public static boolean isPowerOfTwo(int n){
            return (n&(n-1))==0;
    }
    public static void main(String[] args) {
        // System.out.println(getIthBit(12, 2));
        // System.out.println(setIthBit(12, 1));
        // System.out.println(clearIthBit(12, 2));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearIBit(15, 2));
        // System.out.println(clearRnageofBit(10, 1, 5));
        System.out.println(isPowerOfTwo(64));
    }
}