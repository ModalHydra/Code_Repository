class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if(k == len){
            return len;
        }

        int max = 0;
        int frequent = 0;
        int left = 0;
        int array[] = new int[26];

        // fill up the array
        for(int i = 0; i < len; i++){
            array[s.charAt(i) - 'A']++;
            frequent = Math.max(frequent, array[s.charAt(i) - 'A']);

            if((i - left) + 1 - frequent > k){
                array[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, i - left + 1);

        }

        return max;
    }
}