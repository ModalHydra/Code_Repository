class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        ArrayList<Integer> array = new ArrayList<Integer>();
        boolean found = false;
        // sort potions and do binary search for first number

        
        Arrays.sort(potions);

        for(int i = 0; i < n; i++){

            long spell = spells[i];
            long potion = potions[0];
            if(spell * potion >= success){
                array.add(m);
                continue;
            }
            potion = potions[m-1];
            if(spell * potion < success){
                array.add(0);
                continue;
            }
            if(m == 2){
                array.add(1);
                continue;
            }
            
        
            int left = 0;
            int right = m-1;
            int mid = (right-left)/2;

            found = false;
            while(!found){
                potion = potions[mid];
                
                if(left == mid){
                    array.add(m - right);
                    found = true;
                }

                long temp = potions[mid-1];
                
                if(spell * potion < success){ // too low
                    left = mid;
                    mid = mid + (right-left)/2;
                }
                else if(spell*potion >= success && spell*temp < success){
                    found = true;
                    array.add(m - mid);
                }
                else{ // too large
                    right = mid;
                    mid = (right - left)/2;
                }
            }
        }

        int output[] = new int[array.size()];
        
        for(int i = 0; i < array.size(); i++){
            output[i] = array.get(i);
        }
        return output;
    }
}