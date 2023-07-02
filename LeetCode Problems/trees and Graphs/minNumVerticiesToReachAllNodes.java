import java.util.*; 

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        // directed graph -> no cycles in it
        // graph given in the form of a list of lists for edges
        // needs to be done in preferably O(n) time
        int len = edges.size();
        // first find the verticies with no edges pointing to them and added them 
        List<Integer> output = new LinkedList<>();

        // there are n nodes from 0 to n-1

        int array[] = new int[n];


        for(int i = 0; i < len; i++){
            array[edges.get(i).get(1)] = 1;
        }

        for(int i = 0; i < n; i++){
            if(array[i] != 1){
                output.add(i);
            }
        }


        return output;

    }
}