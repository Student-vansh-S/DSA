public class TowerOfHanoi {
    public static void TOH(int n,char src,char helper,char dest){
        if(n==0){
            return;
        }
        TOH(n-1, src, dest, helper);
        System.out.println("Disk "+n+" move from :"+src+" to "+dest);
        TOH(n-1, helper, src, dest);
    }
    public static void main(String[] args) {
        TOH(3, 'A', 'B', 'C');
    }
    
}
