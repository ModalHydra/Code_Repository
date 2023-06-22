import java.util.Hashtable;

class Solution {
    public boolean isHappy(int n) {

        boolean happy = true;

        Hashtable<Integer, Integer> hash = new Hashtable<>();

        int count = 0;

        while(happy){
            if(hash.containsValue(n)){
                return false;
            }
            else if(n ==1){
                return true;
            }
            else{
                hash.put(count,n);
                n = getSumDigits(n);
                count++;
            }
           
        }
        // Math.pow(digit, 2);
        // hash table
        // 

        return happy;
        
    }

    public int getSumDigits(int n){
        String nString = String.valueOf(n);
        int sum = 0;
        for(int i = 0; i < nString.length(); i++){
            sum += Math.pow(Integer.valueOf(nString.charAt(i)) - '0', 2);
        }

        return sum;
    }
}