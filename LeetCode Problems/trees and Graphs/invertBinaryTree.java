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
    public TreeNode invertTree(TreeNode root) {
        
        // recursive function
        // Treenode left = treenode right
        // Treenode right = treenode left
        // call invert Tree on left node
        // call invert Tree on right node
        // only call invert if left node != null and right node != null

        if(root == null){
            return root;
        }

        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null){
            root.left = invertTree(root.left);
        }
        if(root.right != null){
            root.right = invertTree(root.right);
        }

        return root;

    }
}