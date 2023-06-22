class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        long total = 0;
        int array[] = new int[high + 1];
        int minimumZO = Math.min(zero, one);
        int modVal = (int)Math.pow(10,9) + 7;
        
        array[0] = 1;

        if(high == 1){
            return 2;
        }

        for(int i = minimumZO; i < high + 1; i++){
         
            if(i >= one){
                array[i] += array[i - one] % modVal;
            }
            if(i >= zero){
                array[i] += array[i-zero] % modVal;
            }
        }

        for(int i = low; i <= high; i++){
            total += array[i] % modVal;
        }

        

        
        


        return (int)(total % modVal);

    }


// if one = 1 and zero = 1, possible combinations is 2^n where n is length of string
// if one = 2 and zero = 1, possible combinations is 3 when n = 3, and 4 when n = 4
// if one = 3 and zero = 1, possible combinations is 2 when n = 3, and 3 when n = 4
// if one = 4 and zero = 1, possible combinations is 2 when n = 4, and 3 when n = 5, 4 when n = 6
// if one = 2 and zero = 2, possible combinations is 2 when n = 2, and 0 when n = 3, 4 when n = 4
}

