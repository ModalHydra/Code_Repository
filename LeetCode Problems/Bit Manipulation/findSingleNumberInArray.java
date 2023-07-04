class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;

        // 000 XOR 100 = 100
        // 100 XOR 001 = 101
        // 101 XOR 010 = 111
        // 111 XOR 001 = 110
        // 110 XOR 010 = 100 = 4

        for(int i = 0; i < len; i++){
            sum ^= nums[i];
        }


        return sum;
    }
}