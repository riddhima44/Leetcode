// Last updated: 1/19/2026, 10:49:37 PM
class Solution {
    public int maxProfit(int[] prices) {
        int bp=prices[0];
        int maxprofit=0;
        for(int i=1;i<prices.length;i++){
            bp=Math.min(bp,prices[i-1]);
            int sp=prices[i];
            int profit=sp-bp;
            if(maxprofit<profit){
                maxprofit=profit;
            }
        }
        return maxprofit;
    }
}