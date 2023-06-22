class Solution {
    public int[] findBall(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int column;

        int output[] = new int[n];

        // dynamic programming and array are clues

        // how to use dynamic programming to solve
        // idea one create a second grid that contains the paths
        // make is so that if a ball enters a path already traveled i

        // idea 1 is brute force which takes O(nxm)

        for(int i = 0; i < n; i++){
            column = i;
            for(int j = 0; j < m; j++){
                if(column >= n || column < 0){
                    column = -1;
                    j = m;
                }
                else if(grid[j][column] == 1 && (column + 1 >= n || grid[j][column + 1] == -1)){
                    column = -1;
                    j = m;
                }
                else if(grid[j][column] == -1 && (column -1 < 0 || grid[j][column - 1] == 1)){
                    column = -1;
                    j = m;
                }
                else if(grid[j][column] == 1){
                    column++;
                }
                else if(grid[j][column] == -1){
                    column--;
                }
            }
            output[i] = column;
        }

        return output;
        
    }
}