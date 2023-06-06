class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        int len = nums.length;
        int left = 0;
        int right = k-1;

        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        max = sum;

        while(right < len -1){
            right++;
            sum += nums[right];
            sum -= nums[left];
            left++;
            if(sum > max){
                max = sum;
            }
        }


        return (double)max/(double)k;
    }
}