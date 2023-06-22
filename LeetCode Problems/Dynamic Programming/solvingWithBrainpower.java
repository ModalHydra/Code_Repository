class Solution {
    public long mostPoints(int[][] questions) {
        // dynamic programming problem

        // start from the end of the question set
        // keep track of the maximum points for starting at each point

        long max = 0;
        int len = questions.length;
        long array[] = new long[len];
        int brain;
        int points;

        // max of starting at last question

        for(int i = len - 1; i >= 0; i--){
            points = questions[i][0];
            brain = questions[i][1] + 1;
            if(i + brain < len){
                array[i] = Math.max(max, array[i + brain] + points);
            }
            else{
                array[i] = Math.max(max, points);
            }

            if(array[i] > max){
                max = array[i];
            }
        }

        return max;

    }
}