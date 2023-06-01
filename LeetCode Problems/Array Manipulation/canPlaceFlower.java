class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        int max = 0;

        int count = 0;


        // note this could be done in one go through the list by 
        // having a long if statement checking i-1 and i+1

        // eliminate places in array where you can't put new flower
        // turn places adjacent to flowers to -1
        for(int i = 0; i < len; i++){
            if(flowerbed[i] == 1){
                if(i > 0 && i < len -1){
                    if(flowerbed[i - 1] != 1){
                        flowerbed[i-1] = -1;
                    }
                    if(flowerbed[i+1] != 1){
                        flowerbed[i+1] = -1;
                    }
                }
                else if(i > 0){
                    if(flowerbed[i - 1] != 1){
                        flowerbed[i-1] = -1;
                    }
                }
                else if(i < len - 1){
                    if(flowerbed[i+1] != 1){
                        flowerbed[i+1] = -1;
                    }
                }
            }
        }



        // count up the max number of spaces
        for(int i = 0; i < len; i++){
            //System.out.print(flowerbed[i] + " ");
            if(flowerbed[i] == 0){
                count++;
            }
            else if(flowerbed[i] == -1){
                max += count/2 + count%2; // rounded up
                count = 0;
            }
        }

        max += count/2 + count%2; // for end of list

        if(n <= max){
            return true;
        }
        else{
            return false;
        }

    }
}