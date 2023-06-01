class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        boolean swapped = true;

        while(swapped || len == 0){
            swapped = false;

            for(int i = 0; i < len; i++){
                if(nums[i] == 0 && i < len -1){
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    swapped = true;
                }
            }
            len--;
        }
    }
}