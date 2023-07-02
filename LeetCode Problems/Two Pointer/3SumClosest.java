class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // array, two pointers, sorting

        // first sort nums
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int sum = nums[0] + nums[1] + nums[2];
        int difference = Math.abs(target - sum);
        int closestSum = sum;
        int temp;
    

     
        
        for(int i = 0; i < len - 2; i++){
            if(closestSum == target){
                return closestSum;
            }
            left = i + 1;
            right = len - 1;

            while(right - left > 0){
                sum = nums[i] + nums[left] + nums[right];
                temp = Math.abs(target - sum);
                if(temp < difference){
                    closestSum = sum;
                    difference = temp;
                }

                if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }

        }

        
        

        return closestSum;
    }
}