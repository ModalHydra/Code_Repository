class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int len = nums.length;
        //int dp = new int[len];
        int left = 0;
        int right = 0;
        int sum = 0;
        int subLen = 0;
        int minLen = len + 1;

        while(right < len){
            sum += nums[right];
            subLen++;
            while(sum >= target && left <= right){
                if(subLen < minLen){
                    minLen = subLen;
                }

                sum -= nums[left];
                subLen--;
                left++;
            }

            right++;
        }

        if(minLen == len + 1){
            minLen = 0;
        }

        return minLen;
        
    }
}