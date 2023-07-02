import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        

        int len = prerequisites.length;

        Hashtable<Integer, Integer> hash = new Hashtable<>();
        boolean taken[] = new boolean[numCourses];
        Arrays.fill(taken, false);

        for(int i = 0; i < len; i++){
            if(hash.containsKey(prerequisites[i][0])){
                hash.put(prerequisites[i][0], hash.get(prerequisites[i][0]) + 1);
            }
            else{
                hash.put(prerequisites[i][0], 1);
            }
        }


        int output[] = new int[numCourses];
        Arrays.fill(output, -1);
        int index = 0;
        boolean isPossible = true;

        if(len == 0){
            for(int i = 0; i < numCourses; i++){
                output[i] = i;
            }
            return output;
        }

        while(!hash.isEmpty() && isPossible){
            isPossible = false;

            Enumeration<Integer> e = hash.keys();

            while(e.hasMoreElements()){
                int key = e.nextElement();

                if(hash.get(key) <= 0){
                    hash.remove(key);
                }
            }

            for(int i = 0; i < numCourses; i++){
                if(!hash.containsKey(i) && !taken[i]){
                    output[index] = i;
                    index++;
                    taken[i] = true;
                    for(int j = 0; j < len; j++){
                        if(prerequisites[j][1] == i){
                            hash.put(prerequisites[j][0], hash.get(prerequisites[j][0]) - 1);
                            prerequisites[j][1] = -1;
                            isPossible = true;
                        }
                    }
                }
            }

        }

        boolean negativeCheck = true;
        for(int i = 0; i < numCourses; i++){
            if(output[i] == -1){
                negativeCheck = false;
            }
        }

        if(negativeCheck){
            return output;
        }
        else{
            return new int[0];
        }
    }
}