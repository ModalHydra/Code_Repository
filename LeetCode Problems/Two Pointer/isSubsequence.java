class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int lenS = s.length();
        int lenT = t.length();
        boolean valid = false;

        if(lenS == 0){
            valid = true;
        }
        else{
            for(int i = 0; i < lenT; i++){
                if(s.charAt(sIndex) == t.charAt(i)){
                    sIndex++;
                    if(sIndex == lenS){
                        valid = true;
                        i = lenT;
                    }
                }
            }
        }

        return valid;
    }
}