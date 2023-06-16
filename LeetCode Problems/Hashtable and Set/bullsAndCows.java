
import java.util.Hashtable;

class Solution {
    public String getHint(String secret, String guess) {

        // num bulls
        // num cows
        int len = secret.length();
        String output = "";
        int bulls = 0;
        int cows = 0;

        Hashtable<Integer, Character> hash = new Hashtable<>();
        Hashtable<Character, Integer> numAmount = new Hashtable<>();

        // fill hash table
        for(int i = 0; i < len; i++){
            if(numAmount.containsKey(guess.charAt(i))){
                hash.put(i, guess.charAt(i));
                numAmount.put(guess.charAt(i), numAmount.get(guess.charAt(i)) + 1);
            }
            else{
                hash.put(i, guess.charAt(i));
                numAmount.put(guess.charAt(i), 1);
            }
        }

        for(int i = 0; i < len; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
                //numAmount.put(secret.charAt(i), numAmount.get(secret.charAt(i)) - 1);
            }
            if(hash.containsValue(secret.charAt(i)) && numAmount.get(secret.charAt(i)) != 0){
                cows++;
                numAmount.put(secret.charAt(i), numAmount.get(secret.charAt(i)) - 1);
            }
        }

        cows -= bulls;

        System.out.println(hash);
        System.out.println(numAmount);
        output = bulls + "A" + cows + "B";
        return output;        
    }
}