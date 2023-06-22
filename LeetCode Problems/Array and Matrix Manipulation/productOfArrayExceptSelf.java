class Solution {
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int numZero = 0;
        int zeroIndex = 0;

        int output[] = new int[len];

        int product = 1;

        for(int i = 1; i < len; i++){
            if(nums[i] == 0){ // get the only space with a value
                numZero++;
                zeroIndex = i;
            }
            product *= nums[i]; // initial product
        }

        output[0] = product;
        if(numZero == 0){ // if there are no zeros follow formula
            for(int i = 1; i < len; i++){
                output[i] = (output[i-1] * nums[i-1])/nums[i];           
            }
        }
        else if(numZero == 1){ //if one zero only zero index has value
            output[zeroIndex] = 1;
            for(int i = 0; i < len; i++){
                if(i != zeroIndex){
                    output[zeroIndex] *= nums[i];
                }
            }
        }

        // if there are more than 1 zero output has only zeros

        return output;
    }
}