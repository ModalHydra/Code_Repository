class Solution {
    public String longestCommonPrefix(String[] strs) {

        // one way to solve this is with a trie

        String output = "";

        // since string length is so small I'll use brute force

        // num words
        int len = strs.length;
        int maxPreLen = strs[0].length();

        // find the length of the sortest word

        for(int i = 1; i < len; i++){
            if(strs[i].length() < maxPreLen){
                maxPreLen = strs[i].length();
            }
        }

        for(int i = 0; i < maxPreLen; i++){
            for(int j = 0; j < len - 1; j++){
                // make sure all chars are the same
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    return output;
                }
            }
            output += strs[0].charAt(i);
        }

        return output;
        
    }
}