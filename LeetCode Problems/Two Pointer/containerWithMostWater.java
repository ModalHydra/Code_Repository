class Solution {
    public int maxArea(int[] height) {
        // height of area is min of two heights
        // width of area is distance between two heights
        int len = height.length;
        // easy to solve in O(n^2) just go through all possible options
        // problem is because n can be 10^5 the problem can't be solved in that time
        // need to solve problem in O(nlog(n)^2) or less

        int maxArea = 0;
        int leftPtr = 0;
        int rightPtr = len-1;

        // both recursion and dp take O(n^2) and can't be used

        while(leftPtr < rightPtr){
            int distance = rightPtr - leftPtr;
            int area = calcArea(height[leftPtr],height[rightPtr], distance);
            if(maxArea < area){
                maxArea = area;
            }

            if(height[leftPtr] < height[rightPtr]){
                leftPtr++;
            }
            else{
                rightPtr--;
            }
        }
        

        // this is solved with two pointers one at each end.
        // find the area and move the pointer with the smaller height
        // do this unill the pointers are pointing at the same index
        // keep track of the max area while doing this.

        

        


        return maxArea;

    }

    public int calcArea(int height1, int height2, int distance){
        int height = Math.min(height1, height2);

        return height * distance;
    }
}