class Solution {
    public double average(int[] salary) {
        double avg;
        double sum = 0;
        double len = salary.length;
        int minIndex = 0, maxIndex = 0; 
        // first find the maximum and minimum values indexes
        // get a sum of all except max and min index
        for(int i = 0; i < len; i++){
            if(salary[i] > salary[maxIndex]){
                maxIndex = i;
            }
            if(salary[i] < salary[minIndex]){
                minIndex = i;
            }
        }

        for(int i = 0; i < len; i++){
            if(i != minIndex && i != maxIndex){
                sum += salary[i];
            }
        }
        
        return sum/(len - 2.0);
    }
}