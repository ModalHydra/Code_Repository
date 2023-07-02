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
    public boolean isSymmetric(TreeNode root) {
        // easy do same thing as last time but make left 

        return isSameTree(root.left, root.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // changed the function so that it looks for symetric trees
        // instead of p.left q.left I do p.left and q.right

        if(p == null && q == null){
            return true;
        }
        else if(p != null && q != null){
            if(p.val != q.val){
                return false;
            }
            else{
                return isSameTree(p.left, q.right) && isSameTree(p.right,q.left);
            }
        }
        else{
            return false;
        }

    }
}