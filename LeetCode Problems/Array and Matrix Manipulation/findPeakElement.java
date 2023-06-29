class Solution {
    public int findPeakElement(int[] nums) {
        // to find peak element we need to find the largest element


        // to do so binary search in the direction that has the larger value
        int n = nums.length;
        int left = 0, right = n - 1, mid = (right - left)/2;
        int index = mid;

        if(isPeak(nums, left)){
            index = left;
        }
        else if(isPeak(nums, right)){
            index = right;
        }
        else{
            while(!isPeak(nums, mid)){
                if(nums[mid - 1] > nums[mid+1]){
                    right = mid;
                    mid = (right - left)/2;
                }
                else if(nums[mid - 1] <= nums[mid+1]){
                    left = mid;
                    mid = mid + (right - left)/2;
                }

                index = mid;
            }

        }


        return index;
    }

    public boolean isPeak(int[] nums, int index){
        boolean output = false;
        int n = nums.length;


        if(n == 1){ // only one element is automatically a peak
            output = true;
        }
        else if(index == 0){
            if(nums[index] > nums[index + 1]){
                output = true;
            } 
        }
        else if(index == n-1){ 
            if(nums[index] > nums[index - 1]){
                output = true;
            }
        }
        else if(n>2 && nums[index] > nums[index+1] && nums[index] > nums[index-1]){
            output = true; // index in body of array
        }

        return output;
    }
}