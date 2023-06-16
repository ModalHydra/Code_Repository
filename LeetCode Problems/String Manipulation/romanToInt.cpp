class Solution {
    public:
        int romanToInt(string s) {
            
    
            int len = s.length();
            int total = 0;
            int firstNum = charToNum(s[0]);
            int secondNum = charToNum(s[1]);
    
            for(int i = 0; i < len; i++){
                firstNum = charToNum(s[i]);
                if(i+1 < len){
                    secondNum = charToNum(s[i+1]);
                }
    
                if(firstNum < secondNum && i+1 < len){
                    total += secondNum - firstNum;
                    i++;
                }
                else{
                    total += firstNum;
                }
            }
            
    
            return total;
            
        }
    
        int charToNum(char x){
            int total = 0;
            switch(x){
                    case 'I':
                        total += 1;
                        break;
                    case 'V':
                        total += 5;
                        break;
                    case 'X':
                        total += 10;
                        break;
                    case 'L':
                        total += 50;
                        break;
                    case 'C':
                        total += 100;
                        break;
                    case 'D':
                        total += 500;
                        break;
                    case 'M':
                        total += 1000;
                }
            return total;
        }
    };