import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void knapsack(int[] weight ,int[] value, int w){
        double[][] ratio = new double[value.length][2];
        // column 0: index, column 1: value-to-weight ratio

        for(int i=0;i<value.length;i++){
            ratio[i][0]=i;
            ratio[i][1]= value[i]/(double)weight[i];
        }

        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o ->o[1]));

        int capacity = w;
        double finalVal = 0;
        for(int i = ratio.length-1;i>=0;i--){ // include full time
            int idx = (int)ratio[i][0];
            if (capacity >= weight[idx]) {
                finalVal += value[idx];
                capacity -= weight[idx];
            }else{
                // include fractional item
                finalVal += ((double)value[idx]/weight[idx]) * capacity;
                capacity =0;
                break;
            }
        }
        System.out.println("Final Value: " + finalVal);
    }
    public static void main(String[] args) {
        int weight[] = {10,20,30};
        int value[] = {60,100,120}; 
        int w = 50;
        knapsack(weight, value, w);
    }   
}
