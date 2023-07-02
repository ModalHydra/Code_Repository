class Solution {
    public boolean canPartition(int[] nums) {

        // dynamic programming find any subset of numbers equal to half total
        int len = nums.length;

        int total = 0;

        for(int i = 0; i < len; i++){
            total += nums[i];
        }

        // if total value of nums is odd can split into two even subsets
        if(total %2 != 0){
            return false;
        }
        else if(total == 0){
            return true;
        }

        int half = total/2;

        // look for a substring equal to half

        
        // use knapsack solution with weight of half
        int dp[][] = new int[len+1][half+1];

        for(int i = 0; i < len + 1; i++){
            for(int j = 0; j < half + 1; j++){
                dp[i][j] = -1;
            }
        }

        int result = subsetFinder(nums, half, len-1, dp);

        if(result == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public int subsetFinder(int[] nums, int weight, int index, int[][] dp){
        if(weight == 0){
            return 1;
        }

        if(index < 0){
            return 0;
        }

        if(dp[index][weight] != -1){
            return dp[index][weight];
        }

        if(nums[index] > weight){
            return dp[index][weight] = subsetFinder(nums, weight, index - 1, dp);
        }


        return dp[index][weight] = Math.max(subsetFinder(nums, weight - nums[index], index - 1, dp), subsetFinder(nums, weight, index - 1, dp));
    }

  
}