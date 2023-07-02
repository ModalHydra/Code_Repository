class Solution {
    public:
        int lengthOfLongestSubstring(string s) {
            int longestSub = 0;
            int currentSub = 0;
            //s = "jbpnbwwd"; // expected is 4
            int length = s.length();
            // there is the long way by manually going through all characters in the string
            // O(n^2) solution doing it this way exceeds the time limit on the last testcase
            // need two pointers and sliding window to solve
            string substring = "";
            string currentLongestString = "";
    
            for(int i = 0; i < length; i++){
                // add characters to substring until a repeating character is found
                for(int j = 0; j < s.length(); j++){
                    // add characters to substring until a repeating character is found
                    if(inSubstring(substring, s[j])){
                        currentSub = 0;
                        substring = "";
                    }
                    else{
                        currentSub++;
                        substring += s[j];
                    }
                    // check to see if a longer substring is found
                    if(currentSub > longestSub){
                        longestSub = currentSub;
                        currentLongestString = substring;
                    }
                    if(longestSub >= 95){
                        return longestSub;
                    }
                }
                substring = "";
                currentSub = 0;
                //cout << currentLongestString << endl;
                // remove the first letter from string s
                if(longestSub >= 95){
                    return longestSub;
                }
                s = removeFirstLetter(s);
            }
    
            return longestSub;
        }
    
        bool inSubstring(string sub, char character){
            bool isIn = false;
    
            for(int i = 0; i < sub.length(); i++){
                if(sub[i] == character){
                    isIn = true;
                }
            }
    
            return isIn;
        }
    
        string removeFirstLetter(string s){
    
            string temp = "";
            for(int i = 1; i < s.length(); i++){
                temp += s[i];
            }
    
            return temp;
        }
    };