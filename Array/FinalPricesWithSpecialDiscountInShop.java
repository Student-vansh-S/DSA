public class FinalPricesWithSpecialDiscountInShop {
    public static int[] finalPrices(int[] prices) {
        int[] res= new int[prices.length];
        for(int i=0;i<prices.length;i++){
            boolean flag=false;
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<=prices[i] && j>i){
                    res[i]=prices[i]-prices[j];
                    flag=true;
                    break;
                }
            }
            if (!flag) {
                res[i]=prices[i];
            }
        }
        return res;

    //Approach 2
    // int n = prices.length;
    // int[] res = prices.clone();
    // Stack<Integer> stack = new Stack<>();
    // for (int i = 0; i < n; i++) {
    //     while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
    //         int idx = stack.pop();
    //         res[idx] -= prices[i];
    //     }
    //     stack.push(i);
    // }
    // return res;
    }
    public static void main(String args[]){
        int prices[] = {8,4,6,2,3};
        int res[]=finalPrices(prices);
        for(int i=0;i<prices.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
