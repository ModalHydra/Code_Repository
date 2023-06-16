class Solution {
    public:
        string longestPalindrome(string s) {
            
            int len = s.length();
            int firstCharacterPosition = 0;
            int longestLen = 1;
            string longestSubstring = "";
    
            bool dpTable[len][len];
    
            // set all values in dpTable as false
            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++){
                    dpTable[i][j] = false;
                }
            }
    
            // all individual letters are a palindrome of length 1
            for(int i = 0; i < len; i++){
                dpTable[i][i] = true;
                firstCharacterPosition = i;
            }
            
            // need to check for palindromes of length 2
            for(int i = 0; i < len - 1; i++){
                if(s[i] == s[i + 1]){
                    dpTable[i][i+1] = true;
                    longestLen = 2;
                    firstCharacterPosition = i;
                }
            }
    
            cout << longestLen << endl;
            int temp;
            for(int i = 3; i <= len; i++){
                for(int j = 0; j < len - i + 1; j++){
                    temp = i + j - 1;
    
                    if(s[temp] == s[j] && dpTable[j+1][temp-1]){
                        dpTable[j][temp] = true;
    
                        if(i > longestLen){
                            longestLen = i;
                            firstCharacterPosition = j;
                        }
                    }
                }
            }
    
            for(int i = firstCharacterPosition; i < firstCharacterPosition + longestLen; i++){
                longestSubstring += s[i];
            }
    
            return longestSubstring;
            
        }
        
    };