class Solution {
    public int rob(int[] nums) {
        
        // dynamic programming
        int len = nums.length;
        //int max = 0;

        if(len == 1){
            return nums[0];
        }
        if(len ==2){
            return Math.max(nums[0], nums[1]);
        }

        int array[] = new int[len];

        array[len - 1] = nums[len - 1];
        array[len - 2] = Math.max(nums[len-2], array[len-1]);


        for(int i = len -3; i >= 0; i--){
            if(nums[i] + array[i+2] > array[i+1]){
                array[i] = nums[i] + array[i+2];
            }
            else{
                array[i] = array[i+1];
            }
        }

        return array[0];
    }
}