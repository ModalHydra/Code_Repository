class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> output = new ArrayList<List<Integer>>();

        // like with the phone one ( recursive function and for loop going through)
        // indexKey but starting at a specific index on each recursion.
        ArrayList<Integer> current = new ArrayList<Integer>();
        combinationSumHelper(k,n,output,current, 1);

        return output;
    }

    public void combinationSumHelper(int k, int n, ArrayList<List<Integer>> output, ArrayList<Integer> current, int starting){
        if(n == 0 && k == 0){
            output.add(current);
        }

        if(k > 0){
            for(int i = starting; i <= 9; i++){
                if(current.size() == 0 || i > current.get(current.size() - 1)){
                current.add(i);
                combinationSumHelper(k - 1, n - i, output, (ArrayList)current.clone(), starting + 1);
                current.remove(current.size() - 1);
                }
            }
        }
    }
}