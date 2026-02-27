public class StockPrice {
    static int buyAndSellStocks(int prices[]){
        int buyprice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(buyprice<prices[i]){
               int currProfit=prices[i]-buyprice;//today's profit
               maxProfit=Math.max(currProfit,maxProfit);
            }else{
                buyprice=prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[]={7,1,5,3,6,4};
        int result=0;
        result=buyAndSellStocks(prices);
        System.out.println("Highest profit :"+result);
    }
}
