/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // end recursion instances
        if(root == null){
            return root;
        }
        else if(root == p){
            return p;
        }
        else if(root == q){
            return q;
        }

        // get both paths
        TreeNode leftPath = lowestCommonAncestor(root.left, p, q);
        TreeNode rightPath = lowestCommonAncestor(root.right, p, q);

        if(leftPath == null && rightPath == null){ 
            return null;
        }
        else if(leftPath != null && rightPath != null){
            return root;
        }
        else if(leftPath == null && rightPath != null){
            return rightPath;
        }
        else{
            return leftPath;
        }

    }
}