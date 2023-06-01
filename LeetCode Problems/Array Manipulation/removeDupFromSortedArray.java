class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int pointer = 1;
        int lastUnique = nums[0];

        for(int i = 1; i < len; i++){
            if(nums[i] != lastUnique){
                lastUnique = nums[i];
                nums[pointer] = nums[i];
                pointer++;
            }
        }


        

        return pointer;
        
    }
}