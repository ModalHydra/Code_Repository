class Solution {
    public boolean isIsomorphic(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        boolean valid = true;
        int sArray[] = new int[200];
        int tArray[] = new int[200];

        // if the string length are not equal can't be isomorphic
        if(lenS != lenT){
            valid = false;
        }
        else{
            for(int i = 0; i < lenS; i++){
                
                if(sArray[s.charAt(i)] != tArray[t.charAt(i)]){
                    valid = false;
                }

                sArray[s.charAt(i)] = i+1;
                tArray[t.charAt(i)] = i+1; 
            }
        }

        return valid;
    }
}