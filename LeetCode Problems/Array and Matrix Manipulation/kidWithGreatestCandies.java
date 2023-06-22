class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        // find max
        int len = candies.length;
        // loop again to see if greater than max
        // if yes add true to array else add false
        int max = candies[0];

        for(int i = 0; i < len; i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }

        List<Boolean> result = new ArrayList<>();

        for(int i = 0; i < len; i++){
            if(candies[i] + extraCandies >= max){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }

        return result;
        
    }
}