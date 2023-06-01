class Solution {
    public int maxProfit(int[] prices) {
        // dynamic programming
        int len = prices.length;
        int maxProf = 0;
        int maxPrice = 10000000;

        

        for(int i = 0; i < len; i++){
            maxPrice = Math.min(maxPrice, prices[i]);
            maxProf = Math.max(maxProf, prices[i] - maxPrice);
        }

        return maxProf;

    }

}