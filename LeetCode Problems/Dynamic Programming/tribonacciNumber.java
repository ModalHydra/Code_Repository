class Solution {
    public int tribonacci(int n) {

        int array[] = new int[n + 1];
        if(n == 0){
            return 0;
        }
        else if(n < 3){
            return 1;
        }
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;

        for(int i = 3; i < n + 1; i++){
            array[i] = array[i-1] + array[i-2] + array[i-3];
        } 

        return array[n];
        
    }
}