class Solution {
    public int search(int[] nums, int target) {
        
        int index = -1;

        int len = nums.length;
        int leftIndex = 0;
        int rightIndex = len - 1;
        int midIndex = (rightIndex-leftIndex)/2;
        System.out.println(midIndex);


        // go to mid point of array
        // if target is greater than midpoint value go right
        // if targer is less than midpoint value go left
        // find midpoint of next half
        // repeat
        if(nums[rightIndex] == target){
            index = rightIndex;
        }
        if(nums[leftIndex] == target){
            index = leftIndex;
        }

        while(nums[midIndex] != target && rightIndex-leftIndex > 1){
            if(nums[midIndex] < target){
                leftIndex = midIndex;
                midIndex = midIndex + (rightIndex-leftIndex)/2;
                System.out.println(midIndex);
            }
            else if(nums[midIndex] > target){
                rightIndex = midIndex;
                midIndex = (rightIndex-leftIndex)/2;
                System.out.println(midIndex);
            }
            else{
                index = midIndex;
            }
        }

        if(nums[midIndex] == target){
            index = midIndex;
        }

        return index;
    }
}