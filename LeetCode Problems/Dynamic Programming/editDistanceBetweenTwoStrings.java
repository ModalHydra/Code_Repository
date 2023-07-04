class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int dp[][] = new int[len1 + 1][len2 + 1];

        // there are three possible actions that can take place
        // delete a character
        int del = 0;
        // insert a new character
        int ins = 0;
        // replace a character
        int rep = 0;


        /*
              h o r s e
            r 0 1 2 3 4
            o 1 1 2 2 3
            s 2 2 1 2 3

            // every move to the right is inserting a new character
            // every move down is deleting a character
            // every move diagonally is either replacing or staying the same
        */


        if(len1 == 0 || len2 == 0){ // base case (only insert or delete)
            return Math.max(len1,len2);
        }

        

        for(int i = 0; i < len1 + 1; i++){ // base case
            dp[i][0] = i;
        }

        for(int j = 0; j < len2 + 1; j++){ // base case
            dp[0][j] = j;
        }

        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                if(word1.charAt(i - 1) == word2.charAt(j -1)){
                    dp[i][j] = dp[i - 1][j - 1]; // no change needed equal
                }
                else{
                    del = dp[i-1][j] + 1; // delete
                    ins = dp[i][j - 1] + 1; // insert
                    rep = dp[i-1][j-1] + 1; // replace
                    dp[i][j] = Math.min(del,Math.min(ins,rep)); // min
                }
            }
        }

        //printDP(dp);


        return dp[len1][len2];
        
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