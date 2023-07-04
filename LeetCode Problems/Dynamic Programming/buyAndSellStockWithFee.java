class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;

        int dp[][] = new int[2][len];

        dp[0][0] = -prices[0]; // own a stock 
        dp[1][0] = 0; // you don't own a stock

        for(int i = 1; i < len; i++){
            dp[1][i] = Math.max(dp[1][i-1], prices[i] + dp[0][i-1] - fee);
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1] - prices[i]);

            

            

        }

        //printDP(dp);

        return dp[1][len - 1];


    }

    public void printDP(int[][] dp){

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}