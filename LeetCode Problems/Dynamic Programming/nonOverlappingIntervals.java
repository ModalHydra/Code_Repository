class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;

        // use dynamic programming and sorting
        // sort the intervals by their start values
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // dp[i] is the number of removals needed for 0 through i
        int dp[] = new int[len];

        /*
        for(int i = 0; i < len; i++){
            System.out.println("[" + intervals[i][0] + "," + intervals[i][1] + "]");
        }
        */

        dp[0] = 0; // one interval means no overlapping 0 removals
        int rightPtr = intervals[0][1];

        for(int i = 1; i < len; i++){
            if(intervals[i][0] < rightPtr){ // found overlap
                dp[i] = dp[i-1]+1;
                if(intervals[i][1] < rightPtr){ // completley in interval
                    rightPtr = intervals[i][1];
                }
            }
            else{ // no overlap
                dp[i] = dp[i-1];
                rightPtr = intervals[i][1];
            }
        }

        /*
        for(int i = 0; i < len; i++){
            System.out.println("dp " + i + " = " + dp[i]);
        }
        */
        

        return dp[len - 1];
        
    }
}