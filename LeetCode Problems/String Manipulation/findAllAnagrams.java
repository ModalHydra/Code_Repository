import java.util.Hashtable;
import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        // add all of p's letters to a hash table along with their amount
        // starting from index 0 of s look at the next p.len characters
        // make sure they are all in the hash table if yes add index to 

        int sLen = s.length();
        int pLen = p.length();

        int array[] = new int[26];
        int area[] = new int[26];
        List<Integer> output = new ArrayList<Integer>();

        if(pLen > sLen){
            return output;
        }

        for(int i = 0; i < pLen; i++){
            array[p.charAt(i) - 'a']++;
            area[s.charAt(i) - 'a']++;
        }
        
        if(Arrays.equals(array, area)){
            output.add(0);
        }

        for(int i = pLen; i < sLen; i++){
            area[s.charAt(i-pLen) - 'a']--;
            area[s.charAt(i) - 'a']++;
            if(Arrays.equals(array, area)){
                output.add(i - pLen + 1);
            }
        }
       

        
        

        return output;
        
    }

    
}