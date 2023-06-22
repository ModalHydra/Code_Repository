class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean valid = false;

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n - 1;
        int mid = right/2;

        int y = mid/n;
        int x = mid%n;
        int temp = matrix[y][x];

        System.out.println(target);

        if(matrix[0][0] == target){
            valid = true;
        }
        else if(matrix[m-1][n-1] == target){
            valid = true;
        }
        
        while(right - left > 1 && temp != target){
            temp = matrix[y][x];
            if(temp < target){
                left = mid;
                mid = mid + (right - left)/2;
                y = mid/n;
                x = mid%n;
            }
            else if(temp > target){
                right = mid;
                mid = (right - left)/2;
                y = mid/n;
                x = mid%n;
            }
            else{
                valid = true;
            }
        }

        if(temp == target){
            valid = true;
        }
        // how to do binary search

        // step one find the mid point is it larger or lower than target
        // if larger have low equal mid + 1
        // if lower have high equal mid

        // need to preform binary search on matrix

        return valid;
    }

}