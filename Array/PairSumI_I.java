import java.util.ArrayList;
public class PairSumI_I {
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
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            if (arr.get(left) + arr.get(right) == target) {
                return true;
            }
            else if(arr.get(left)+arr.get(right)>target){
                right--;
            }
            else{
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(pairSum(arr, 5));
    }
}
