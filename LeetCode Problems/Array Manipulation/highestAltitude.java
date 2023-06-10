class Solution {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int max = 0;
        int len = gain.length;

        for(int i = 0; i < len; i++){
            current += gain[i];
            if(current > max){
                max = current;
            }
        }

        return max;
        
    }
}