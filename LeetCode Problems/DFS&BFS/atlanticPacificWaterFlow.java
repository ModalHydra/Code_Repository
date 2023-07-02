class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        // ok for this to be O(n^2)

        List<List<Integer>> output = new LinkedList<>();
        int m = heights.length;
        int n = heights[0].length;
        List<Integer> temp;
        boolean atl = false;
        boolean pac = false;

        // for each square perform atlantic dps and pacific dps
        // if true for both add to output 
        int [][] gridCopy = new int[m][];

        for(int i = 0; i < m; i++){
            gridCopy[i] = heights[i].clone();
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //System.out.println("Position: " + i + " " + j);
                for(int k = 0; k < m; k++){
                    gridCopy[k] = heights[k].clone();
                }

                if(atlanticDPS(gridCopy, i, j, m, n)){
                    atl = true;
                }

                for(int k = 0; k < m; k++){
                    gridCopy[k] = heights[k].clone();
                }

                if(pacificDPS(gridCopy, i, j, m, n)){
                    pac = true;
                }

                if(atl && pac){
                    temp = new LinkedList<>();
                    temp.add(i);
                    temp.add(j);
                    output.add(temp);
                }

                pac = false;
                atl = false;
            }
        }


        return output;
    }

    public boolean atlanticDPS(int [][] heights, int y, int x, int m, int n){
        boolean output = false;
        int currentHeight = heights[y][x];
        heights[y][x] = 10000000;
        //System.out.println("Atlantic search: Y = " + y + " X = " + x);
        if(y == m -1 || x == n -1){
            return true;
        }
        else{
            if(x - 1 >= 0)// left
            {
                if(currentHeight >= heights[y][x -1]){
                    output = atlanticDPS(heights, y, x-1, m, n);
                    if(output){
                        return output;
                    }
                }
            }
            if(x + 1 < n)// right
            {
                if(currentHeight >= heights[y][x + 1]){
                    output = atlanticDPS(heights, y, x+1, m, n);
                    if(output){
                        return output;
                    }
                }
            }
            if(y - 1 >= 0)// up
            {
                if(currentHeight >= heights[y - 1][x]){
                    output = atlanticDPS(heights, y - 1, x, m, n);
                    if(output){
                        return output;
                    }
                }
            }
            if(y + 1 < m)// down
            {
                if(currentHeight >= heights[y + 1][x]){
                    output = atlanticDPS(heights, y + 1, x, m, n);
                    if(output){
                        return output;
                    }
                }
            }
        }

        return output;
    }

    public boolean pacificDPS(int [][] heights, int y, int x, int m, int n){
        boolean output = false;
        int currentHeight = heights[y][x];
        heights[y][x] = 10000000;
        //System.out.println("Pacific search: Y = " + y + " X = " + x);
        if(y == 0 || x == 0){
            return true;
        }
        else{
            if(x - 1 >= 0)// left
            {
                if(currentHeight >= heights[y][x -1]){
                    output = pacificDPS(heights, y, x-1, m, n);
                    if(output){
                        return output;
                    }
                }
            }
            if(x + 1 < n)// right
            {
                if(currentHeight >= heights[y][x +1]){
                    output = pacificDPS(heights, y, x+1, m, n);
                    if(output){
                        return output;
                    }
                }
            }
            if(y - 1 >= 0)// up
            {
                if(currentHeight >= heights[y - 1][x]){
                    output = pacificDPS(heights, y - 1, x, m, n);
                    if(output){
                        return output;
                    }
                }
            }
            if(y + 1 < m)// down
            {
                if(currentHeight >= heights[y + 1][x]){
                    output = pacificDPS(heights, y + 1, x, m, n);
                    if(output){
                        return output;
                    }
                }
            }
        }
        
        return output;
    }
}