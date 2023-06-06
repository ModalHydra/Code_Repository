class Solution {
    public String removeStars(String s) {
        // answer create a stack and continue to add non-star letters to the stack
        // when a star is encountered pop a character from the stack
        // if the stack is empty do nothing
        // at the end build the final string from the letters left in the stack

        // would be more efficient in the future to use string builder from the start instead of string

        Stack<Character> charStack = new Stack<>();

        String output = "";
        int len = s.length();

        for(int i = 0; i < len; i++){
            if(s.charAt(i) != '*'){
                charStack.push(s.charAt(i));
            }
            else{
                if(!charStack.empty()){
                    charStack.pop();
                }
            }
        }

        while(!charStack.isEmpty()){ 
            output+=charStack.pop();
        }
        StringBuilder sb=new StringBuilder(output);
        sb.reverse();

        return sb.toString();

    }

    public String removeLastChar(String s){
        return s.substring(0, s.length() - 1);
    }

    
}