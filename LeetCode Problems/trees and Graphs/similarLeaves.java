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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {


        // looking back it's probably better to use array lists instead of string builder
        StringBuilder str = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        leaves(root1, str);
        leaves(root2, str2);

       if(str.toString().equals(str2.toString())){
           return true;
       }

        return false;
    }

    public void leaves(TreeNode root, StringBuilder str){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            str.append(root.val);
            str.append(' ');
            return;
        }
        leaves(root.left,str);
        leaves(root.right,str);
    }
}