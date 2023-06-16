class Solution {
public:
    bool isPalindrome(int x) {
        // converte x to string
        // create a reverse string
        // compair reverse and current 
        // if x is negative return false

        string xString = to_string(x);
        string reverseX = xString;
        reverse(reverseX.begin(), reverseX.end());

        if(xString == reverseX){
            return true;
        }
        else{
            return false;
        }

    }
};