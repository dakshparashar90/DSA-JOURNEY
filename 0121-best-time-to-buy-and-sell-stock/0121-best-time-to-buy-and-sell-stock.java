class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int sell=0;
        int mx=0;

        for(int i=1;i<prices.length;i++){
            sell=prices[i];
            int profit=sell-buy;

            mx=Math.max(mx,profit);
            buy=Math.min(prices[i],buy);
        }
        return mx;
    }
}