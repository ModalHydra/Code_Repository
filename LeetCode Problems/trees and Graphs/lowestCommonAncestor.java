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
        // this is a binary tree so we can use math
        // lowest common ancestor would be between p and q
        // 
        // navagate to p from root
        // navagate to q from root
        if(root == null){
            return root;
        }

        // the root is the greatest common ancestor 
        // if p.val and q.val greater than root.val next ancestor is root.right
        // if p.val and q.val less than root.val next ancestor is root.left
        // else root is lowest common ancestor

        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            return root;
        }


    }
}