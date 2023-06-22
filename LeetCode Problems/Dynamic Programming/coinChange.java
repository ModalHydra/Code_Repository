class Solution {
    public int coinChange(int[] coins, int amount) {
        // dynamic programming


        if(amount == 0){
            return 0;
        }

        int array[] = new int[amount + 1];
        Arrays.fill(array,amount+1);
        int coinLen = coins.length;

        
        array[0] = 0;


        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coinLen; j++){
                if(i >= coins[j]){
                    array[i] = Math.min(array[i], array[i-coins[j]] + 1);
                }
            }

        }

        if(array[amount] <= amount)
        {
            return array[amount];
        }
        else{
            return -1;
        }

    }
    

}