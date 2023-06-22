class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> output = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        boolean spiral = true;
        int x = -1;
        int y = 0;
        
        if(n == 1 && m == 1){
            output.add(matrix[0][0]);
            return output;
        }

        while(spiral){
            x++;
            if(x < n && matrix[y][x] == -101){
                spiral = false;
            }
            while(x < n && matrix[y][x] != -101 ){
                //System.out.println("right y " + y + " x " + x);
                output.add(matrix[y][x]);
                matrix[y][x] = -101;
                x++;
            }
            x--;
            //System.out.println(" ");
            y++;
            if(y < m && matrix[y][x] == -101){
                spiral = false;
            }
            while(y < m && matrix[y][x] != -101){
                //System.out.println("down y " + y + " x " + x);
                output.add(matrix[y][x]);
                matrix[y][x] = -101;
                y++;
            }
            y--;
            System.out.println(" ");
            x--;
            if(x >= 0 && matrix[y][x] == -101){
                spiral = false;
            }
            while(x >= 0 && matrix[y][x] != -101){
                //System.out.println("left y " + y + " x " + x);
                output.add(matrix[y][x]);
                matrix[y][x] = -101;
                x--;
            }
            x++;
            //System.out.println(" ");
            y--;
            if(y >= 0 && matrix[y][x] == -101){
                spiral = false;
            }
            while(y >= 0 && matrix[y][x] != -101){
                //System.out.println("up y " + y + " x " + x);
                output.add(matrix[y][x]);
                matrix[y][x] = -101;
                y--;
            }
            y++;
            //System.out.println(" ");
        }
        // output a row remove that row
        // output a column remove that column
        
        return output;
    }
}