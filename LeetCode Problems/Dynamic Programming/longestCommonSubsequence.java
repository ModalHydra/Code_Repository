class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int max = 0;

        int dp[][] = new int[len1][len2];
                
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    if(i == 0 && j == 0){
                        dp[i][j] = 1;
                    }
                    else if(i > 0 && j == 0){
                        dp[i][j] = 1;
                    }
                    else if(i == 0 && j > 0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j-1] +1;
                    }
                }
                else if(i == 0 && j == 0){
                    dp[i][j] = 0;
                }
                else if(i > 0 && j == 0){
                    dp[i][j] = dp[i-1][j];
                }
                else if(i == 0 && j > 0){
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        max = dp[len1 - 1][len2 - 1];

        

        //printDP(dp);

        return max;
    }

    public void printDP(int dp[][]){
        int n = dp.length;
        int m = dp[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}