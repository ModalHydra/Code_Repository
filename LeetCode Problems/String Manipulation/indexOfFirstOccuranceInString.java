class Solution {
    public int strStr(String haystack, String needle) {
        int nLen = needle.length();
        int hLen = haystack.length();

        boolean found = false;

        if(hLen < nLen){
            return -1;
        }

        for(int i = 0; i < hLen - nLen + 1; i++){

            if(haystack.charAt(i) == needle.charAt(0)){
                found = true;
                for(int j = 0; j < nLen; j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        found = false;
                    }
                }

                if(found){
                    return i;
                }
            }
        }

        return -1;
        
    }
}