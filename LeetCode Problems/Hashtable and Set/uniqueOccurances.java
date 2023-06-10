import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Hashtable<Integer, Integer> hash = new Hashtable<>();
        Set<Integer> set = new HashSet<>();


        for(int x:arr){
            if(hash.containsKey(x)){
                hash.replace(x, hash.get(x) + 1);
            }
            else{
                hash.put(x, 0);
            }
        }

        for(int x:hash.keySet()){
            if(set.contains(hash.get(x))){
                return false;
            }
            else{
                set.add(hash.get(x));
            }
        }
    

    
        return true;
    }
}