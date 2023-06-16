class Solution {
    public int climbStairs(int n) {
        

        // have to use dynamic programming

        int array[] = new int[n + 1];

        if(n < 3){
            return n;
        }

        array[0] = 0;
        array[1] = 1;
        array[2] = 2;

        for(int i = 3; i < n + 1; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
      
      

        return array[n];
    }
}