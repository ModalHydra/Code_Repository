class Solution {
    public int equalPairs(int[][] grid) {
        // there is a O(n^2) solution that is easy
        // just compare every row and column

        int n = grid.length;
        int col[] = new int[n];
        int output = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                col[j] = grid[j][i];
            }
            for(int j = 0; j < n; j++){
                if(compareRC(grid[j], col, n)){
                    output++;
                }
            }
        }


        return output;
    }

    public boolean compareRC(int[] row, int[] column, int n){
        for(int i = 0; i < n; i++){
            if(row[i] != column[i]){
                return false;
            }
        }
        return true;
    }
}