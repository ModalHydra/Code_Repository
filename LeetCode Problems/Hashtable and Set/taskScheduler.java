import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int numIdle = 0;
        int maxLetterAmount = 0;
        int numFreeSpaces = 0;
        int numLettersFillInSpace = 0;
        int numDifLetters = 0;
        Hashtable<Character, Integer> hash = new Hashtable<>();
        if(n == 0){
            return len;
        }
        // fill up hash table
        for(int i = 0; i < len; i++){
            if(hash.containsKey(tasks[i])){
                hash.put(tasks[i], hash.get(tasks[i]) + 1);
            }
            else{
                hash.put(tasks[i], 1);
                numDifLetters++;
            }
        }

        Enumeration<Character> e = hash.keys();
        // get the max letter amount
        while (e.hasMoreElements()) {
            char key = e.nextElement();
            if(hash.get(key) > maxLetterAmount){
                maxLetterAmount = hash.get(key);
            }
        }

        // get the number of letters to fill in space
        e = hash.keys();

        n++;
        while (e.hasMoreElements()) {
            char key = e.nextElement();
            if(hash.get(key) != maxLetterAmount){
                numLettersFillInSpace += hash.get(key);
            }
            else{
                n--;
            }
        }

        numFreeSpaces = (maxLetterAmount - 1) * n;
        numIdle = numFreeSpaces - (numLettersFillInSpace);

        if(numIdle < 0){
            numIdle = 0;
        }

        return len + numIdle;
        
    }
}