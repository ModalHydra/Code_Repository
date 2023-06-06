class Solution {
    public int maxVowels(String s, int k) {
        int vowelCount = 0;
        int maxVowel = 0;
        int left = 0; 
        int right = k-1;
        int len = s.length();

        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))){
                vowelCount++;
            }
        }
        maxVowel = vowelCount;

        while(right < len - 1){
            right++;
            if(isVowel(s.charAt(right))){
                vowelCount++;
            }
            if(isVowel(s.charAt(left))){
                vowelCount--;
            }
            left++;
            if(vowelCount > maxVowel){
                maxVowel = vowelCount;
            }
        }

        return maxVowel;

    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}