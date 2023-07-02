class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        int right = nums.length - 1; 
        int left = 0; 
        int mid = (right - left)/2;
        
        if(nums[mid] == target){
            index = mid;
        }
        else if(nums[left] == target){
            index = left;
        }
        else if(nums[right] == target){
            index = right;
        }

        while((right - left) > 0 && mid < nums.length && nums[mid] != target){
            if(nums[mid] >= nums[left]){
                if(nums[left] < target && nums[mid] > target){
                    right = mid - 1;
                    mid = left + (right - left)/2;
                }
                else{
                    left = mid + 1;
                    mid = left + (right - left)/2;
                }
            }
            else{
                if(nums[right] > target && nums[mid] < target){
                    left = mid + 1;
                    mid = left + (right - left)/2;
                }
                else{
                    right = mid - 1;
                    mid = left + (right - left)/2;
                }
            }

            if(nums[mid] == target){
                index = mid;
            }
            if(nums[left] == target){
                index = left;
            }
            if(nums[right] == target){
                index = right;
            }

            System.out.println("Left " + left + " Right " + right + " mid " + mid);

        }
        // binary search until

        if(mid > 0 && mid < nums.length && nums[mid] == target){
            index = mid;
        }

        return index;
    }
}