class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int len = nums.length;
        int output[] = new int[2];

        // cannot sort as it gets rid of original indicies
        // could use a hash table to sort by mapping value to indice


        // brute force
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(i != j && nums[i] + nums[j] == target){
                    output[0] = i;
                    output[1] = j;
                    i = len;
                    j = len;
                }
            }
        }

        // use a hash table to find two indices
        // add all nums to a hash table along with indicies
        // 

        return output;
    }
}