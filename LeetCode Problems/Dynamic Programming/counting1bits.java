class Solution {
    public int[] countBits(int n) {

        // I could convert the int to a bit and manually count 1s
        // that would take O(N^2)

        //0 (0) 0
        //1 (1) 1
        //10 (1) 2
        //11 (2) 3
        //100 (1) 4
        //101 (2) 5
        //110 (2) 6
        //111 (3) 7
        //1000 (1) 8
        //1001 (2) 9 
        //1010 (2) 10
        //1011 (3) 11
        //1100 (2) 12
        //1101 (3) 13
        //1110 (3) 14
        //1111 (4) 15
        //10000 (1) 16
        

        // output[i] = output[i/2] when even and output[i-1]+1 when odd 

        int output[] = new int[n+1];


        for(int i = 0; i < n+1; i++){
            if(i == 0){
                output[i] = 0;
            }
            else if(i%2 == 1){ // is odd
                output[i] = output[i-1]+1;
            }
            else{ // is even
                output[i] = output[i/2];
            }

        }
        

        return output;


    }
}