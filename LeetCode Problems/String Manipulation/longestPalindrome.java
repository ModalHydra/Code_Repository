class Solution {
    public int longestPalindrome(String s) {
        // max of odd number letter + all even number letter values

        // need to hash each letter with an int value
        int len = s.length();
        int arrayUp[] = new int[26];
        int arrayLow[] = new int[26];
        int max = 0;
        boolean hasOdd = false;

        for(int i = 0; i < 26; i++){
            arrayUp[i] = 0;
            arrayLow[i] = 0;
        }

        for(int i = 0; i < len; i++){
            if(Character.isUpperCase(s.charAt(i))){
                arrayUp[s.charAt(i) - 'A']++;
            }
            else{
                arrayLow[s.charAt(i) - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++){
            if(arrayUp[i] %2 == 0){
                max += arrayUp[i];
            }
            else{
                max += arrayUp[i] - 1;
                hasOdd = true;
            }
            if(arrayLow[i] % 2 == 0){
                max += arrayLow[i];
            }
            else{
                max += arrayLow[i] - 1;
                hasOdd = true;
            }
        }

       if(hasOdd){
           max++;
       }

        return max;
        
    }
}