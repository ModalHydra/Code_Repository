/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        

        // use a helper function to pass the minimum and maximum values for the left and right

        return isValidBSTHelper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root, long maxValue, long minValue){
        if(root == null){
            return true;
        }
        if(root.val >= maxValue || root.val <= minValue){
            return false;
        }
        return (isValidBSTHelper(root.left, root.val, minValue) && isValidBSTHelper(root.right, maxValue, root.val));
         
    }
}