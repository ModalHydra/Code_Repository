class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
      

        int len = cost.length;
        int minArray[] = new int[len];

        minArray[len - 1] = cost[len - 1];
        minArray[len - 2] = cost[len - 2];

        for(int i = len - 3; i >= 0; i--){
            minArray[i] = cost[i] + Math.min(minArray[i + 1], minArray[i + 2]);
        }
        

        return Math.min(minArray[0], minArray[1]);
        
    }
}