import java.util.Hashtable;
import java.util.Enumeration;

class wordNode{
    String word;
    int amount;

    public wordNode(String w, int a){
        this.word = w;
        this.amount = a;
    } 
    public wordNode(){
        this.word = "";
        this.amount = 0;
    }

    public int getAmount(){
        return this.amount;
    }
    public String getWord(){
        return this.word;
    }
    public void setAmount(int a){
        this.amount = a;
    }
    public void setWord(String s){
        this.word = s;
    }
}

class nodeComparator implements Comparator<wordNode>{
             
            // Overriding compare()method of Comparator
                        // for descending order of cgpa
    public int compare(wordNode word1, wordNode word2) {
        if (word1.getAmount() < word2.getAmount())
            return 1;
        else if (word1.getAmount() > word2.getAmount())
            return -1;
        else if (word1.getAmount() == word2.getAmount()){
                return word1.getWord().compareTo(word2.getWord());
        }
        return 0;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        int len = words.length;
        List<String> output = new ArrayList<>();

        // could use hash table with words as key and value as amount
        // would take O(n^2) to search through hash table for most frequent word k times

        Hashtable<String, Integer> hash = new Hashtable<>();
        PriorityQueue<wordNode> queue = new PriorityQueue<>(new nodeComparator());

        for(int i = 0; i < len; i++){
            if(hash.containsKey(words[i])){
                hash.put(words[i], hash.get(words[i]) + 1);
            }
            else{
                hash.put(words[i], 1);
            }
        }

        Enumeration<String> e = hash.keys();
        int numNodes = hash.size();

        wordNode array[] = new wordNode[numNodes];
        int count = 0;

        while (e.hasMoreElements()) {
            // Getting the key of a particular entry
            String key = e.nextElement();
            array[count] = new wordNode(key, hash.get(key));
            count++;
        }

        for(int i = 0; i < numNodes; i++){
            queue.add(array[i]);
        }

        for(int i = 0; i < k; i++){
            output.add(queue.poll().getWord());
        }

        

        return output;
    }
}