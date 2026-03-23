import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoin {
    public static void change(Integer[] coin, int amount){
        Arrays.sort(coin, Comparator.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();
        int countOfCoin = 0;
        for(int i=0;i<coin.length;i++){
            if (coin[i]<=amount) {
                while (coin[i]<=amount) {
                    countOfCoin++;
                    ans.add(coin[i]);
                    amount -= coin[i];
                }
            }
        }
        System.out.println("Total min coins used :"+countOfCoin);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    } 
    public static void main(String[] args) {
        Integer[] coin = {1,2,5,10,20,50,100,500,2000};
        int amount= 590;
        change(coin, amount); 
    }
    
}
