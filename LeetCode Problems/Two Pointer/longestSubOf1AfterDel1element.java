class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int left = 0; 
        int right = 0;
        int max = 0;
        int count = 0;
        int numZero = 0;

        while(right < len){
            if(numZero <= 1){
                if(nums[right] == 1){
                    count++;
                }
                if(nums[right] == 0){
                    numZero++;
                }
                right++;
            }

            if(numZero > 1){
                if(nums[left] == 1){
                    count--;
                }
                if(nums[left] == 0){
                    numZero--;
                }
                left++;
            }

            if(count > max){
                max = count;
            }
            
        }
        if(numZero == 0){
            return max - 1;
        }
        else{
            return max;
        }
    }
}