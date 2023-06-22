class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack stack = new Stack();
        // might be better with string builder or ArrayList of char
        String modifiedS = "";
        String modifiedT = "";
        int sLen = s.length();
        int tLen = t.length();

        for(int i = 0; i < sLen; i++){
            if(s.charAt(i) == '#' && !stack.empty()){
                stack.pop();
            }
            else if(s.charAt(i) != '#'){
                stack.push(s.charAt(i));
            }
        }

        while(!stack.empty()){
            modifiedS += stack.pop();
        }

        for(int i = 0; i < tLen; i++){
            if(t.charAt(i) == '#' && !stack.empty()){
                stack.pop();
            }
            else if(t.charAt(i) != '#'){
                stack.push(t.charAt(i));
            }
        }

        while(!stack.empty()){
            modifiedT += stack.pop();
        }

        if(modifiedT.equals(modifiedS)){
            return true;
        }
        else{
            return false;
        }




    }
}