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
    public int diameterOfBinaryTree(TreeNode root) {
        // how to find distance from one node to another
        if(root == null){
            return 0;
        }

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        int endToEnd = depth(root.left) + depth(root.right);

        if(left > right){
            return Math.max(left, endToEnd);
        }
        else{
            return Math.max(right, endToEnd);
        }

    }
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        
        
        return Math.max(left, right) + 1;
    }
}