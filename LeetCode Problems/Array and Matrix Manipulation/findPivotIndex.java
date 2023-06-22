class Solution {
    public int pivotIndex(int[] nums) {
        int index = -1;
        int rightSum = 0;
        int leftSum = 0;

        for(int i = 0; i < nums.length; i++){
            rightSum += nums[i];
        }
        rightSum -= nums[0];

        for(int i = 0; i < nums.length; i++){
            if(leftSum == rightSum){
                index = i;
                i = nums.length;
            }
            else{
                leftSum += nums[i];
                if(i < nums.length - 1){
                    rightSum -= nums[i+1];
                }
            }
        }

        if(nums.length == 1){
            index = 0;
        }

        return index;
    }
}