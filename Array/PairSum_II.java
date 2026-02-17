import java.util.ArrayList;
public class PairSum_II {
    public static boolean pairSum(ArrayList<Integer> arr, int target) {
        // brute force
        // for(int i=0;i<arr.size();i++){
        // for(int j=i+1;j<arr.size();j++){
        // if(arr.get(i)+arr.get(j)==target){
        // return true;
        // }
        // }
        // }

        // 2 pointer approach
        int n=arr.size();
        int bp=-1; // breaking point index
        for(int i=0;i<n;i++){
            if(arr.get(i)>arr.get(i+1)){
                bp=i;
                break;
            }
        }
        int left = bp+1;
        int right = bp;
        while (left != right) {
            if (arr.get(left) + arr.get(right) == target) {
                return true;
            }
            else if(arr.get(left)+arr.get(right)>target){
                right=(n+right-1)%n;
            }
            else{
                left=(left+1)%n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(15);
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        System.out.println(pairSum(arr, 16));
    }
}

