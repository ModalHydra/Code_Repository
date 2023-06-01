class Solution {
    public int compress(char[] chars) {
        int output = 0;
        int len = chars.length;
        char currentChar = ' ';
        int tempNum = 0;


        for(int i = 0; i < len; i++){
            if(tempNum == 0){
                currentChar = chars[i];
            }
            if(currentChar == chars[i]){
                tempNum++;
            }
            if(currentChar != chars[i]){
                String temp = Integer.toString(tempNum);
                if(tempNum == 1){
                    chars[output] = currentChar;
                    output++;
                }
                else{
                    chars[output] = currentChar;
                    output++;
                    for(int j = 0; j < temp.length(); j++){
                        chars[output] = temp.charAt(j);
                        output++;
                    }
                }
                tempNum = 0;
                i--;
            }
        }

        String temp = Integer.toString(tempNum);
        if(tempNum == 1){
            chars[output] = currentChar;
            output++;
        }
        else{
            chars[output] = currentChar;
            output++;
            for(int j = 0; j < temp.length(); j++){
                chars[output] = temp.charAt(j);
                output++;
            }
        }
        tempNum = 0;
        

        return output;
    }
}