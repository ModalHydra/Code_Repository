class Solution {
    public String predictPartyVictory(String senate) {
        int len = senate.length();
        Queue<Character> queue = new LinkedList<>();
        int numDire = 0;
        int numRemoveD = 0;
        int numRadiant = 0;
        int numRemoveR = 0;
        char temp;

        // first count Dire and Radiant and add them to the queue

        for(int i = 0; i < len; i++){
            temp = senate.charAt(i);
            queue.add(temp);
            if(temp == 'R'){
                numRadiant++;
            }
            else{
                numDire++;
            }
        }

        // make use of a revolving queue where if a member still
        // has voting rights add them to the back of the queue
        // if they don't remove them form the queue
        // when the queue only has one type of party that party wins

        while(queue.peek() != null && numDire != 0 && numRadiant != 0){
            temp = queue.remove();
            if(temp == 'R'){
                if(numRemoveR == 0){
                    queue.add(temp);
                    numRemoveD++;
                }
                else{
                    numRemoveR--;
                    numRadiant--;
                }
            }
            else{
                if(numRemoveD == 0){
                    queue.add(temp);
                    numRemoveR++;
                }
                else{
                    numRemoveD--;
                    numDire--;
                }
            }

        }

        if(numDire == 0){
            return "Radiant";
        }
        else{
            return "Dire";
        }

    }
}