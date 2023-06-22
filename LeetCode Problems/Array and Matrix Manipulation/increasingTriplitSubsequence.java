class Solution {
    public boolean increasingTriplet(int[] nums) {

        // have three max values
        // go through the array one time
        // if else statement for values
        boolean output = false;
        int len = nums.length;
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++){
            if(nums[i] <= max1){
                max1 = nums[i];
            }
            else if(nums[i] <= max2){
                max2 = nums[i];
            }
            else{
                return true;
            }
        }

        

        return output;

    }
}