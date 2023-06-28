/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

 public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid = (right - left)/2 + 1;
        boolean found = false;

        if(guess(n) == 0){
            return n;
        }
        if(guess(1) == 0){
            return 1;
        }

        while(!found){
            int res = guess(mid);
            if(res == 1){ // higher
                left = mid;
                mid = mid + (right-left)/2;
            }
            else if(res == -1){ // lower
                right = mid;
                mid = (right - left)/2;
            }
            else{ // found number
                found = true;
            }
        }

        return mid;
    }
}