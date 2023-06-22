class Solution {
    public boolean divideArray(int[] nums) {
        int array[] = new int[500];
        int len = nums.length;
        Arrays.fill(array, 0);

        for(int i = 0; i < len; i++){
            array[nums[i] - 1]++;
        }
        for(int i = 0; i < 500; i++){
            if(array[i]%2 != 0){
                return false;
            }
        }

        return true;
    }
}