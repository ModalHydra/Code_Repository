class Solution {
    
    public int numTilings(int n) {
        int dp[] = new int[n+1];

        int modVal = (int)Math.pow(10,9) + 7;

        System.out.println(modVal);
       
        if(n < 3){
            return n;
        }

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < n+1; i++){
            dp[i] = (2*dp[i-1]%modVal + dp[i-3])%modVal;
        }


        return dp[n]%modVal;
    }
}