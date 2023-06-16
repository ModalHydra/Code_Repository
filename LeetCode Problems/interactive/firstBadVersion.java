/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        // use binary search to find the first bad version

        // if mid is bad go left if mid is good go right

        int left = 1, right = n;
        int mid = 0;

        if(isBadVersion(1)){
            return 1;
        }

        while(left < right){
            mid = left + (int)Math.floor((right-left+1)/2);
            if(isBadVersion(mid)){
                if(isBadVersion(mid - 1)){ // if the one left of the bad version is bad search
                    right = mid - 1;
                }
                else{ // left of bad is not bad so found first bad
                    return mid;
                }
            }
            else{
                left = mid;
            }
        }

        return mid;
    }
}