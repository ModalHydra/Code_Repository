class Solution {
    public int longestOnes(int[] nums, int k) {
        
        // this can probably be solved with dp too
        int len = nums.length;
        int max = 0;
        int count = 0;
        int numZero = 0;
        int left = 0;
        int right = 0;

        if(k == len){ // all zeros can be flipped
            return len;
        }

        while(right < len){

            if(numZero <= k){
                if(nums[right] == 0){
                    numZero++;
                }
                right++;
                count++;
            }
            if(numZero > k){
                if(nums[left] == 0){
                    numZero--;
                }
                left++;
                count--;
            }

            if(count > max){
                max = count;
            }
        }

        return max;
    }
}