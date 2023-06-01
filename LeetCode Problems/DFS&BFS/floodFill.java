class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // get the initial color
        // change sr,sc to new color, sr is up down in matrix, sc is left right
        // if left value == initial color call floodFill on that value
        // if right value == initial color call floodFill on that value
        // if up value == initial color call floodFill on that value
        // if down value == initial color call floodFill on that value
        // when doning this make sure to check if area is out of bounds
        // check up, down, left, right on

        int m = image.length;
        int n = image[0].length;
        int initialColor = image[sr][sc];
        image[sr][sc] = color;
        if(color == initialColor){
            return image;
        }
        if(sc - 1 >= 0){
            if(image[sr][sc - 1] == initialColor){
                image = floodFill(image, sr, sc - 1, color);
            }
        }
        if(sc + 1 < n){
            if(image[sr][sc + 1] == initialColor){
                image = floodFill(image, sr, sc + 1, color);
            }
        }
        if(sr - 1 >= 0){
            if(image[sr-1][sc] == initialColor){
                image = floodFill(image, sr - 1, sc, color);
            }
        }
        if(sr + 1 < m){
            if(image[sr + 1][sc] == initialColor){
                image = floodFill(image, sr + 1, sc, color);
            }
        }
        return image;

    }
}