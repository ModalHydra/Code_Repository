#include <stack>

class Solution {
public:
    bool isValid(string s) {
        bool valid = true;
        stack<char> stack;

        for(int i = 0; i < s.length(); i++){
            if(s[i] == '('){
                stack.push('(');
            }
            if(s[i] == ')'){
                if(stack.empty()){
                    valid = false;
                }
                else if(stack.top() != '('){
                    valid = false;
                }
                else{
                    stack.pop();
                }
            }
            if(s[i] == '{'){
                stack.push('{');
            }
            if(s[i] == '}'){
                if(stack.empty()){
                    valid = false;
                }
                else if(stack.top() != '{'){
                    valid = false;
                }
                else{
                    stack.pop();
                }
            }
            if(s[i] == '['){
                stack.push('[');
            }
            if(s[i] == ']'){
                if(stack.empty()){
                    valid = false;
                }
                else if(stack.top() != '['){
                    valid = false;
                }
                else{
                    stack.pop();
                }
            }
        }

        if(!stack.empty()) {
            valid = false;
        }    

        return valid;
    }
};