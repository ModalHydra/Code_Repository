class Solution {
    public int minFlips(int a, int b, int c) {

        
        int count = 0;
        int len = Math.max(a,Math.max(b,c));
        len = Integer.toBinaryString(len).length();
        

        for(int i = 0; i < len; i++){
            if((c & (1L << i)) == 0){ // c bit is 0 both b and a need to be 0
                if((a & (1L << i)) != 0){
                    count++;
                }
                if((b & (1L << i)) != 0){
                    count++;
                }
            }
            else{ // c bit is 1 a or b need to be 1
                if((a & (1L << i)) == 0 && (b & (1L << i)) == 0){
                    count++;
                }
            }
        }

        //printBinary(a);
        //printBinary(b);
        //printBinary(c);
        

        /*
            100    100 -> a
            010    011 -> b
            ---- > ---- 
            111    111 -> c

            my_byte &= ~(1 << pos); turn a specific bit to 0

            (value & (1L << x)) != 0 checks if bit at positoin x is 1 or 0 for value

        */

        return count;

        
    }

    public void printBinary(int num){
        System.out.println(num + " = " + Integer.toBinaryString(num));
    }

}