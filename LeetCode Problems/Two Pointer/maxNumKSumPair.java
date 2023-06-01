class Solution {
    public int maxOperations(int[] nums, int k) {
        int ptr1 = 0;
        int ptr2 = 0;
        int len = nums.length;
        int numOperations = 0;
        int otherArray[] = new int[len];

        if(len < 2){
            return numOperations;
        }

        for(int i = 0; i < len; i++){
            otherArray[i] = k - nums[i];
        }
        Arrays.sort(otherArray);
        Arrays.sort(nums);

        while(ptr2 < len && ptr1 < len){
            //System.out.println(otherArray[ptr2] + " " + nums[ptr1]);
            if(otherArray[ptr2] < 1){
                ptr2++;
            }
            else if(otherArray[ptr2] == nums[ptr1]){
                numOperations++;
                ptr2++;
                ptr1++;
            }
            else if(otherArray[ptr2] < nums[ptr1]){
                ptr2++;
            }
            else{
                ptr1++;
            }
        }
        return numOperations/2;
    }
}