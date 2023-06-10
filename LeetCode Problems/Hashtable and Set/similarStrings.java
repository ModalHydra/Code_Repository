import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        Set<Character> set = new HashSet<>();
        int len1 = word1.length();
        int len2 = word2.length();
        int array1[] = new int[26];
        int array2[] = new int[26];

        if(len1 != len2){ // need to have the same number of characters
            return false;
        }
        

        for(int i = 0; i < len1; i++){
            array1[word1.charAt(i)%26]++;
            array2[word2.charAt(i)%26]++;
            set.add(word1.charAt(i));
        }
        Arrays.sort(array1);
        Arrays.sort(array2);

        // need same number of character amount
        for(int i = 0; i < 26; i++){
            if(array1[i] != array2[i]){
                return false;
            }
        }

        // need to have the same set of characters
        for(int i = 0; i < len2; i++){ 
            if(!set.contains(word2.charAt(i))){
                return false;
            }
        }

        return true;

    }
}